package kbsc.kbsc.domain.heartedPost.api;

import kbsc.kbsc.domain.heartedPost.application.HeartedPostService;
import kbsc.kbsc.domain.heartedPost.domain.heartedPost;
import kbsc.kbsc.domain.heartedPost.dto.heartedPostDTO;
import kbsc.kbsc.domain.post.domain.PostResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/heart")
public class HeartedPostController {

    private final HeartedPostService heartedPostService;

    public HeartedPostController(HeartedPostService heartedPostService) {
        this.heartedPostService = heartedPostService;
    }

    @PostMapping("/{postidx}/{useridx}")
    public boolean clickHeart(@PathVariable Long postidx, @PathVariable Long useridx) {
        String result = heartedPostService.addHeart(new heartedPostDTO(postidx, useridx));
        return true;
    }

   /* @GetMapping("/{usesridx}")
    public List<PostResult> */



}
