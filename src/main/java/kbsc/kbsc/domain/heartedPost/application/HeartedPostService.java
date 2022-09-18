package kbsc.kbsc.domain.heartedPost.application;

import kbsc.kbsc.domain.heartedPost.dao.HeartedPostRepository;
import kbsc.kbsc.domain.heartedPost.domain.HeartedPost;
import kbsc.kbsc.domain.heartedPost.dto.HeartedPostDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class HeartedPostService {

    private final HeartedPostRepository heartedPostRepository;


    public HeartedPostService(HeartedPostRepository heartedPostRepository) {
        this.heartedPostRepository = heartedPostRepository;
    }

    //heart 누른적있는지 -> 없으면 추가, 있으면 삭제
    public boolean isHearted(HeartedPostDTO heartedPostDTO) {
        Optional<HeartedPost> cur = heartedPostRepository
                .findHeartedPostByUserIdxAndPostIdx(heartedPostDTO.getPostIdx(), heartedPostDTO.getUserIdx());
        AtomicBoolean result = new AtomicBoolean(false);
        cur.ifPresent(selectedHeartedPost -> {
           result.set(true);
        });
        return result;
    }
    public String addHeart(HeartedPostDTO heartedPostDto) {
        HeartedPost heartedPost = new HeartedPost();
        heartedPost.setPostIdx(heartedPost.getPostIdx());
        heartedPost.setUserIdx(heartedPostDto.getUserIdx());
        heartedPostRepository.save(heartedPost);
        return "ok";
    }
}
