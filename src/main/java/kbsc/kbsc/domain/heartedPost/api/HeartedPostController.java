package kbsc.kbsc.domain.heartedPost.api;

import kbsc.kbsc.domain.heartedPost.application.HeartedPostService;
import kbsc.kbsc.domain.heartedPost.dto.HeartedPostDTO;
import kbsc.kbsc.domain.post.application.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/heart")
public class HeartedPostController {

    private final HeartedPostService heartedPostService;

    @Autowired
    public HeartedPostController(HeartedPostService heartedPostService) {
        this.heartedPostService = heartedPostService;
    }

    @PostMapping("/{postidx}/{useridx}")
    public boolean clickHeart(@PathVariable Long postidx, @PathVariable Long useridx) {
        HeartedPostDTO heartedPostDTO = new HeartedPostDTO(postidx, useridx);
        if(heartedPostService.isHearted(heartedPostDTO) != null)//존재하는 좋아요 -> 좋아요 취소해야함
        {
            heartedPostService.dropHeart(heartedPostDTO);
            log.info("dropHeart");

        }
        else // 존재하지않는 찜 정보 -> 좋아요
        {
            heartedPostService.addHeart(heartedPostDTO);
            log.info("saveHeart");

        }
        return true;
    }

   /* @GetMapping("/{usesridx}")
    public List<PostResult> */



}
