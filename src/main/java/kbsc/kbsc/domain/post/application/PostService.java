package kbsc.kbsc.domain.post.application;

import kbsc.kbsc.domain.post.dao.PostRespository;
import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.post.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRespository postRepository;

    //게시글 업로드
    @Transactional
    public Post createPostByUser(PostDto userPostDto){ //TODO: userid 연결해야함
        Post newPost = new Post();
        newPost.setUserId(userPostDto.getUserId());
        newPost.setTitle(userPostDto.getTitle());
        newPost.setContents(userPostDto.getContent());
        return postRepository.save(newPost);
    }

    //게시글 조회
    public Post getSinglePost(Long postId){
        return postRepository.findByPostId(postId);
    }

    //게시글 목록 조회
    public List<Post> getAllPost(){
        try{
            return postRepository.findAll();
        } catch (NoResultException e){
            return new ArrayList<>();
        }
    }

   /* //유저 아이디로 게시글 조회
    @Transactional
    public List<Post> searchPostsByUserId(Long userId) {
        List<Post> postList = postRepository.findByUserId(userId);
        if(postList.isEmpty()) return new ArrayList<>();
        return postList;
    }*/
}
