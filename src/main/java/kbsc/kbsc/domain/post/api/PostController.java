package kbsc.kbsc.domain.post.api;

//TODO: 해당 코드 모두 실제 서비스 코드로 리팩토링 필요함
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kbsc.kbsc.domain.post.application.PostService;
import kbsc.kbsc.domain.post.constant.PostConstants;
import kbsc.kbsc.domain.post.dto.PostDto;
import kbsc.kbsc.domain.post.entity.Post;
import kbsc.kbsc.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import kbsc.kbsc.domain.post.dto.PostDto;
import kbsc.kbsc.domain.post.dto.PostDto.CreateRequest;
import kbsc.kbsc.domain.post.dto.PostDto.CreateResponse;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.CacheRequest;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor //생성자 주입 https://velog.io/@developerjun0615/Spring-RequiredArgsConstructor-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%9C-%EC%83%9D%EC%84%B1%EC%9E%90-%EC%A3%BC%EC%9E%85
@RestController
@RequestMapping("/posts")
@Api(tags="Post API")
public class PostController {
    private final PostService postService;

    @ApiOperation(value="게시글 작성", notes="게시글을 작성합니다.")
    @PostMapping
    public ResponseEntity<?> createPost(@Valid @ModelAttribute CreateRequest createRequest){
        CreateResponse createResponse = this.postService.createPost(createRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(PostConstants.EPostController.LOCATION_ID_PATH.getValue())
                .buildAndExpand(createResponse.getPostId())
                .toUri();
        return ResponseEntity.created(location).body(ResponseDto.create(
                PostConstants.EPostResponseMessage.CREATE_POST_SUCCESS.getMessage(),
                createResponse));
    }



    @ApiOperation(value = "특정 게시글 조회", notes = "특정 게시글을 조회합니다.")
    @GetMapping("/{postId}")
    //서버가 http응답의 바디뿐만 아니라 status나 header를 조작해야 하는 경우 @ResponseDTO가 아닌 @ResponseEntity를 사용한다. 
    public ResponseEntity<?> getDetailPost(@PathVariable Long postId) {
        return ResponseEntity.ok(
                ResponseDto.create( //ResponseDto(string msg, T dto) 객체 생성
                        PostConstants.EPostResponseMessage.GET_DETAIL_POST_SUCCESS.getMessage(),
                        this.postService.getDetailPost(postId)));
    }


//    @ApiOperation(value="게시글 작성 시간 순 목록 조회", notes="게시글 작성 시간 순 목록을 조회합니다.")
//    @GetMapping



}