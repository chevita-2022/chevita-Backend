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
        log.info("1. postIdx={}", resultPost.getPostIdx());
        PostResult postResult = new PostResult(resultPost);
        log.info("2. postIdx={}", postResult.getPostIdx());
        postResult.setImgUrls(postDto.getImgUrls());
        PostResult result = postResultService.saveImg(postResult);
        log.info("3. postIdx={}", result.getPostIdx());
        return ResponseEntity.ok().body(new CommonResponse(result));
    }

    @ApiOperation(value = "postId로 특정 게시글 조회", notes = "postId로 특정 게시글 조회")
    @GetMapping("/{postid}")
    public ResponseEntity<? extends BasicResponse> getPostByPostId(@PathVariable Long postid){
        Post resultPost = postService.getSinglePost(postid);
        PostResult postResult = postResultService.findPostResult(resultPost);
        return ResponseEntity.ok().body(new CommonResponse(postResult));
    }

    @ApiOperation(value = "게시글 목록 조회", notes = "게시글 목록 조회")
    @GetMapping()
    public ResponseEntity<? extends BasicResponse> getAllPostList(){
        List<Post> postList = postService.getAllPost();
        if(postList.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("게시글이 존재하지 않습니다."));
        List<PostResult> postResults = new ArrayList<>();
        for (Post post: postList) {
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
   /* @ApiOperation(value = "나눔 상태 변경", notes = "나눔 상태 변경")
    @PatchMapping("/{postId}/reservation")
    public ResponseEntity<? extends BasicResponse> updateNanumStatus(@PathVariable Long postIdx, @RequestBody ReservationDto reservationDto){
        Reservation resultReservation = reservationService.updateStatus(reservationDto);
    }
*/

/*    @ApiOperation(value = "특정 유저의 게시글 조회", notes = "특정 유저의 게시글 조회")
    @GetMapping("/{userId}")
    public ResponseEntity<? extends BasicResponse> searchByUserId(@PathVariable ("user-id") Long userId){
        List<Post> postList = postService.searchPostsByUserId(userId);
        if (postList.size()==0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("존재하는 게시글이 없습니다"));
        return ResponseEntity.ok().body(new CommonResponse(postList));

    }*/

}
    /*

    @ApiOperation(value = "나눔 상태 변경", notes = "나눔 상태 변경")
    @PatchMapping("/{postId}/reservation")
    public Long updateNanumStatus(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }
    @ApiOperation(value = "나눔 예약 요청", notes = "나눔 예약 요청")
    @PostMapping("/{postId}/reservation")
    public Long requestNanumReservation(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    @ApiOperation(value = "나눔 예약 정보 조회", notes = "나눔 예약 정보 조회")
    @GetMapping("/{postId}/reservation")
    public Long getNanumReservationInfo(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    @ApiOperation(value = "나눔 후기 등록", notes = "나눔 후기 등록")
    @GetMapping("/{postId}/review/nanum")
    public Long addNanumReview(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }
    @ApiOperation(value = "채눔 후기 등록", notes = "채눔 후기 등록")
    @GetMapping("/{postId}/review/chanum")
    public Long addChanumReview(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    /*@ApiOperation(value="특정 게시글 조회", notes = "특정 게시글을 조회합니다.")
    @GetMapping("/{postId}")
    //서버가 http응답의 바디뿐만 아니라 status나 header를 조작해야 하는 경우 @ResponseDTO가 아닌 @ResponseEntity를 사용한다.
    public ResponseEntity<?> getDetailPost(@PathVariable Long postId){
        return ResponseEntity.ok(
                ResponseDto.create( //ResponseDto(string msg, T dto) 객체 생성
                    PostConstants.EPostResponseMessage.GET_DETAIL_POST_SUCCESS.getMessage(),
                    this.postService.getDetailPost(postId)));
    }*/

//    @GetMapping("/dto")
//    public PostDto PostDto(@RequestParam("name") String name,
//                           @RequestParam("amount") int amount) {
//        return new PostDto(name, amount);
//    }


