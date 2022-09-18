package kbsc.kbsc.domain.heartedPost.application;

import kbsc.kbsc.domain.heartedPost.dao.HeartedPostRepository;
import kbsc.kbsc.domain.heartedPost.domain.HeartedPost;
import kbsc.kbsc.domain.heartedPost.dto.HeartedPostDTO;
import kbsc.kbsc.domain.post.application.PostService;
import kbsc.kbsc.domain.post.domain.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class HeartedPostService {


    @Autowired
    private final HeartedPostRepository heartedPostRepository;
    @Autowired
    private final PostService postService;

    @Autowired
    public HeartedPostService(HeartedPostRepository heartedPostRepository, PostService postService) {
        this.heartedPostRepository = heartedPostRepository;
        this.postService = postService;
    }

    //heart 누른적있는지 -> 없으면 추가, 있으면 삭제
    public HeartedPost isHearted(HeartedPostDTO heartedPostDTO) {
        List<HeartedPost> heartedPosts = heartedPostRepository.findAll();
        for (HeartedPost cur: heartedPosts) {
            log.info("{}", cur);
            if(cur.getPostIdx() == heartedPostDTO.getPostIdx() && cur.getUserIdx() == heartedPostDTO.getUserIdx())
                return cur;
        }
        return null;
    }

    //TODO:좋아요 수정될때 post의 totalHearts 수정하기
 /*   public void updateTotalHearts(Long postIdx, Long target) {
        Post post = postService.getSinglePost(postIdx);

    }
*/
    //TODO: ADDhEART 수정하기
    public String addHeart(HeartedPostDTO heartedPostDto) {
        HeartedPost heartedPost = new HeartedPost();
        heartedPost.setPostIdx(heartedPost.getPostIdx());
        heartedPost.setUserIdx(heartedPostDto.getUserIdx());
        heartedPostRepository.save(heartedPost);
        return "ok";
    }

    public String dropHeart(HeartedPostDTO heartedPostDTO) {
        HeartedPost heartedPost = isHearted(heartedPostDTO);
        heartedPostRepository.delete(heartedPost);
        return "ok";
    }
}
