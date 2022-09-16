package kbsc.kbsc.domain.post.application;

import kbsc.kbsc.domain.post.dao.PostRespository;
import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.post.dto.PostDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRespository postRepository;

    //게시글 업로드
    @Transactional
    public Post createPostByUser(PostDto postDto){ //TODO: userid 연결해야함
        Post newPost = new Post();

        newPost.setUserIdx(postDto.getUserId());
        newPost.setTitle(postDto.getTitle());
        newPost.setContents(postDto.getContent());
        newPost.setCategory(postDto.getCategory());
        newPost.setPurchaseDate(postDto.getPurchaseDate());
        newPost.setPurchasedAt(postDto.getPurchasedAt());
        newPost.setOpenedDate(postDto.getOpenedDate());
        newPost.setShelfLife(postDto.getShelfLife());
        newPost.setExpirationDate(postDto.getExpirationDate());
        newPost.setStorageMethod(postDto.getStorageMethod());
        //주소
        newPost.setGlobalLocation(postDto.getGlobalLocation());
        newPost.setDetailedLocation(postDto.getDetailedLocation());

        newPost.setCreatedAt(postDto.getCreatedAt());
        newPost.setUpdatedAt(postDto.getUpdatedAt());
        newPost.setTotalHearts(postDto.getTotalHearts());
        newPost.setReceiptImgUrl(postDto.getReceiptImgUrl());
        newPost.setSeenNumber(postDto.getSeenNumber());
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
    @Transactional
    public Post updatePost(PostDto postDto) {
        Long postId = postDto.getPostId();
        Post post = postRepository.findByPostId(postId);
        LocalDateTime date = LocalDateTime.now();

        post.setTitle(postDto.getTitle());
        post.setContents(postDto.getContent());
        post.setCategory(postDto.getCategory());
        post.setPurchaseDate(postDto.getPurchaseDate());
        post.setPurchasedAt(postDto.getPurchasedAt());
        post.setOpenedDate(postDto.getOpenedDate());
        post.setShelfLife(postDto.getShelfLife());
        post.setExpirationDate(postDto.getExpirationDate());
        post.setStorageMethod(postDto.getStorageMethod());
        post.setDetailedLocation(postDto.getDetailedLocation());
        post.setTotalHearts(postDto.getTotalHearts());
        post.setReceiptImgUrl(postDto.getReceiptImgUrl());
        post.setSeenNumber(postDto.getSeenNumber());

        post.setUpdatedAt(date);
        return postRepository.save(post);
    }

   /* //유저 아이디로 게시글 조회
    @Transactional
    public List<Post> searchPostsByUserId(Long userId) {
        List<Post> postList = postRepository.findByUserId(userId);
        if(postList.isEmpty()) return new ArrayList<>();
        return postList;
    }*/
}
