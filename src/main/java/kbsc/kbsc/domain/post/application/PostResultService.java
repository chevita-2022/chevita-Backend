package kbsc.kbsc.domain.post.application;

import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.post.domain.PostResult;
import kbsc.kbsc.domain.postimage.Repository.PostImageRepository;
import kbsc.kbsc.domain.postimage.dao.impl.PostImageDAOImpl;
import kbsc.kbsc.domain.postimage.domain.PostImage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PostResultService {

    final PostImageDAOImpl postImageDAO;
    final PostImageRepository postImageRepository;


    @Autowired
    public PostResultService(PostImageDAOImpl postImageDAO, PostImageRepository postImageRepository) {
        this.postImageDAO = postImageDAO;
        this.postImageRepository = postImageRepository;
    }

    /*
    *
    * Optional<Users> updateUser = userRepository.findById(targetIdx);
        updateUser.ifPresent(selectUser->{
            selectUser.setUserNickName(user.getUserNickName());
            selectUser.setUserAddress(user.getUserAddress());
            selectUser.setProfileImgUrl(user.getProfileImgUrl());
            selectUser.setIntroduction(user.getIntroduction());
            selectUser.setUserHashTag(user.getUserHashTag());

            userRepository.save(selectUser);
        });*/
    /*
    public PostResult updateImg(PostResult postResult) throws IOException {
        List<String> urls = postResult.getImgUrls();
        for (PostImage postImage: postImageRepository.findAll()) {
            if(postResult.getPostIdx() == postImage.getPostIdx())
            {
                postImage.setImgUrl(postImageDAO.updateImgUrl(postImage));
            }
        }

    }*/
    public PostResult saveImg(PostResult postResult) throws IOException {
            Long postIdx = postResult.getPostIdx();
            log.info("postIdx={}", postIdx);//여기 null 찍힘
            List<String> urls = postResult.getImgUrls();
        List<String> results = new ArrayList<>();
        for(String url : urls) {
            PostImage postImage = PostImage.builder().
                    postIdx(postIdx).
                    imgUrl(url).
                    build();
            postImageDAO.saveImgUrl(postImage);
            results.add(postImage.getImgUrl());
        }
        postResult.setImgUrls(results);
        return postResult;
    }
    public PostResult findPostResult(Post post)
    {
        System.out.println("findPostResult");
        PostResult postResult = new PostResult(post);
        postResult.setImgUrls(postImageDAO.findByPostIdx(post.getPostIdx()));
        //여기서부터 빈리스트임
        log.info("imgurls={}", postResult.getImgUrls());
        return postResult;
    }
}
