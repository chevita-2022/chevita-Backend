package kbsc.kbsc.domain.post.api;

//TODO: 해당 코드 모두 실제 서비스 코드로 리팩토링 필요함
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kbsc.kbsc.domain.post.application.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/posts")
@RestController
@Api(tags="Post API")
public class PostController {
    private final PostService postService; //싱글턴

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ApiOperation(value="게시글 목록 조회", notes = "게시글 목록을 조회합니다.")
    @GetMapping
    public String posts(){
        return "get posts";
    }
    
    @PostMapping
    public String addPosts(){
        return "post posts";
    }
    
    @GetMapping("/{postId}")
    public String findPost(@PathVariable String postId){
        return "get postId ="+ postId;
    }

    @PatchMapping("/{postId}")
    public String updatePost(@PathVariable String postId){
        return "update postId = "+ postId;
    }


}