package kbsc.kbsc.domain.reviews.application;

import kbsc.kbsc.domain.reviews.dao.ReviewsRepository;
import kbsc.kbsc.domain.reviews.domain.Reviews;
import kbsc.kbsc.domain.reviews.dto.WriteReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewService {
    final ReviewsRepository reviewsRepository;

    //후기 작성
    @Transactional
    public Reviews createReview(WriteReviewDto reviewDto){
        Reviews reviews = new Reviews();

        reviews.setUserIdx(reviews.getUserIdx());
        reviews.setNanumiIdx(reviews.getNanumiIdx());
        reviews.setNanumiName(reviews.getNanumiName());
        reviews.setVital(reviews.getVital());
        reviews.setContent(reviews.getContent());

        return reviewsRepository.save(reviews);
    }
    
    //받은 후기 목록 조회


}
