package kbsc.kbsc.domain.heartedPost.application;

import kbsc.kbsc.domain.heartedPost.dao.HeartedPostRepository;
import kbsc.kbsc.domain.heartedPost.domain.heartedPost;
import kbsc.kbsc.domain.heartedPost.dto.heartedPostDTO;
import org.springframework.stereotype.Service;

@Service
public class HeartedPostService {

    private final HeartedPostRepository heartedPostRepository;


    public HeartedPostService(HeartedPostRepository heartedPostRepository) {
        this.heartedPostRepository = heartedPostRepository;
    }

    public String addHeart(heartedPostDTO heartedPostDto) {
        heartedPost heartedPost = new heartedPost();
        heartedPost.setPostIdx(heartedPost.getPostIdx());
        heartedPost.setUserIdx(heartedPostDto.getUserIdx());
        heartedPostRepository.save(heartedPost);
        return "ok";
    }
}
