package kbsc.kbsc.domain.reviews.api;

import io.swagger.annotations.ApiOperation;
import kbsc.kbsc.domain.reviews.application.ReviewService;
import kbsc.kbsc.domain.reviews.domain.Review;
import kbsc.kbsc.domain.reviews.dto.ReviewDTO;
import kbsc.kbsc.domain.reviews.dto.WriteReviewDto;
import kbsc.kbsc.global.util.BasicResponse;
import kbsc.kbsc.global.util.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequestMapping("/reviews")
@RestController
public class ReviewsController {
    final ReviewService reviewService;

    public ReviewsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @ApiOperation(value = "후기글 작성", notes = "요청보낼 칼럼들: " +
            "int userIdx = user idx" +
            "int nanumiIdx = 나누미 idx" +
            "int chaenumiIdx = 채누미 idx" +
            "int vital = 바이탈" +
            "string contents = 작성내용")
    @PostMapping
    public ResponseEntity<? extends BasicResponse> addReview(@RequestBody WriteReviewDto reviewDto) throws IOException {
        Review reviews = reviewService.createReview(reviewDto);
        return ResponseEntity.ok().body(new CommonResponse(reviews));

    }

    //nanumiIdx가 받은 후기들 보여주기 즉 Review 테이블에서 nanumiIdx가 pathvariable인것 찾기
    @GetMapping("/{nanumiIdx}")
    public List<ReviewDTO> getReviewList(@PathVariable Long nanumiIdx) {
        return reviewService.getReviewList(nanumiIdx);
    }
/*




    @ApiOperation(value = "받은 후기글 조회", notes = "요청보낼 칼럼들 " +
            "")
    @GetMapping("/received/userIdx}")
*/



}
