package kbsc.kbsc.domain.post.api;

//TODO: 해당 코드 모두 실제 서비스 코드로 리팩토링 필요함
import io.swagger.annotations.ApiOperation;
import kbsc.kbsc.domain.post.application.PostResultService;
import kbsc.kbsc.domain.post.application.PostService;
import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.post.domain.PostResult;
import kbsc.kbsc.domain.post.dto.PostDto;
import kbsc.kbsc.domain.postimage.dao.impl.PostImageDAOImpl;
import kbsc.kbsc.domain.reservation.application.ReservationService;
import kbsc.kbsc.domain.reservation.domain.Reservation;
import kbsc.kbsc.domain.reservation.dto.ReservationDto;
import kbsc.kbsc.global.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/posts")
@RestController
public class PostController {

    private final PostService postService;
    final PostResultService postResultService;

    public PostController(PostService postService, PostResultService postResultService) {
        this.postService = postService;
        this.postResultService = postResultService;
    }


    @ApiOperation(value = "게시글 작성", notes = "게시글 작성")
    @PostMapping
    public ResponseEntity<? extends BasicResponse> addPost(@RequestBody PostDto postDto) throws IOException {
        Post resultPost = postService.createPostByUser(postDto);

        PostResult postResult = new PostResult(resultPost); // post 테이블 하나 만든거 복붙
        postResult.setImgUrls(postDto.getImgUrls()); //postResult에 이미지 경로 생성
        //가능한 시간대 리스트 생성
        postResult.setSharingTimeZones(postDto.getSharingTimeZones());

        //이미지 저장
        PostResult result = postResultService.saveImg(postResult);
        //시간대 리스트 저장
        PostResult resultWithTimeZone = postResultService.saveSharingTimeZone(result);

        return ResponseEntity.ok().body(new CommonResponse(resultWithTimeZone));
    }

    @ApiOperation(value = "postId로 특정 게시글 조회", notes = "postId로 특정 게시글 조회")
    @GetMapping("/{postid}")
    public ResponseEntity<? extends BasicResponse> getPostByPostId(@PathVariable Long postid) {
        Post resultPost = postService.getSinglePost(postid); //post id로 게시글 하나 찾아오기

        //이미지, 나눔시간대 저장된 것 불러오기
        PostResult postResult = postResultService.findPostResult(resultPost);

        return ResponseEntity.ok().body(new CommonResponse(postResult));
    }

    @ApiOperation(value = "게시글 목록 조회", notes = "게시글 목록 조회")
    @GetMapping()
    public ResponseEntity<? extends BasicResponse> getAllPostList() {
        List<Post> postList = postService.getAllPost();
        if (postList.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("게시글이 존재하지 않습니다."));
        List<PostResult> postResults = new ArrayList<>();
        for (Post post : postList) {
            PostResult postResult = postResultService.findPostResult(post);
            postResults.add(postResult);
        }
        CommonResponse commonResponse = new CommonResponse(postResults);
        return ResponseEntity.ok().body(commonResponse);
    }

    @ApiOperation(value = "게시글 수정", notes = "게시글 수정")
    @PatchMapping("/{postId}")
    public ResponseEntity<? extends BasicResponse> updatePost(@RequestBody PostDto postDto) {
        Post resultPost = postService.updatePost(postDto);
        return ResponseEntity.ok().body(new CommonResponse(resultPost));

    }
}

