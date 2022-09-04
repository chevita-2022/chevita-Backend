package kbsc.kbsc.domain.post.api;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/posts")
@RestController
@Api(tags="Post API")
public class PostController {
    public PostController() {
    }


}