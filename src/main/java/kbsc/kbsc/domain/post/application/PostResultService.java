package kbsc.kbsc.domain.post.application;

import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.post.domain.PostResult;
import kbsc.kbsc.domain.postimage.Repository.PostImageRepository;
import kbsc.kbsc.domain.postimage.dao.impl.PostImageDAOImpl;
import kbsc.kbsc.domain.postimage.domain.PostImage;
import kbsc.kbsc.domain.sharingtimezone.dao.impl.SharingTimeZoneDaoImpl;
import kbsc.kbsc.domain.sharingtimezone.domain.SharingTimeZone;
import kbsc.kbsc.domain.sharingtimezone.repository.SharingTimeZoneRepository;
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
    final SharingTimeZoneDaoImpl sharingTimeZoneDaoImpl;
    final PostImageRepository postImageRepository;
    final SharingTimeZoneRepository sharingTimeZoneRepository;


    @Autowired
    public PostResultService(PostImageDAOImpl postImageDAO, SharingTimeZoneDaoImpl sharingTimeZoneDaoImpl, PostImageRepository postImageRepository, SharingTimeZoneRepository sharingTimeZoneRepository) {
        this.postImageDAO = postImageDAO;
        this.sharingTimeZoneDaoImpl = sharingTimeZoneDaoImpl;
        this.postImageRepository = postImageRepository;
        this.sharingTimeZoneRepository = sharingTimeZoneRepository;
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

    public PostResult saveSharingTimeZone(PostResult postResult) throws IOException{ //이미지까지 저장된 result를 받아옴
            Long postIdx = postResult.getPostIdx(); //post id 찾기
            log.info("postIdx={}", postIdx);
             List<List<String>> availableDates = postResult.getAvailableDates(); //List<List<String>> availableDates;
/*가져온거를  짤라서 디비에 저장할거야
availableDate = [나눔일자, 나눔시간대] = [availableDate.get(0),
availableDates = [[나눔일자, 나눔시간대], [나눔일자, 나눔시간대], [나눔일자, 나눔시간대]] = [availableDate.get(0),
        */
            for(List<String> availableDate: availableDates){ //[나눔일자, 나눔시간대]
                log.info("List<String> availableDate = {}", availableDate );
                SharingTimeZone sharingTimeZone = SharingTimeZone.builder()// sharingTimeZone = [나눔일자, 나눔시간대]
                        .postIdx(postIdx) //TODO: postIdx find 연결
                        .dateZone(availableDate.get(0)) //나눔일자
                        .timeZone(availableDate.get(1)) //나눔시간대
                        .build();
                log.info("sharing get datezone={}", sharingTimeZone.getDateZone());
                log.info("sharing get timezone={}", sharingTimeZone.getTimeZone());
                sharingTimeZoneDaoImpl.saveSharingTimeZone(sharingTimeZone); // Long sharingTimeZoneIdx; Long postIdx; String dateZone;String timeZone;

            }
            postResult.setAvailableDates(availableDates);
            log.info("after setting postResult ={}", postResult.getAvailableDates());
            return postResult;

    }

    public PostResult findPostResult(Post post)
    {
        System.out.println("findPostResult");
        PostResult postResult = new PostResult(post);
        postResult.setImgUrls(postImageDAO.findByPostIdx(post.getPostIdx()));
        //postResult.setSharingTimeZone(sharingTimeZoneDaoImpl.findByPostIdx(post.getPostIdx()));

        //여기서부터 빈리스트임
        log.info("imgurls={}", postResult.getImgUrls());
        return postResult;
    }


}
