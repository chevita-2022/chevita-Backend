package kbsc.kbsc.domain.reviews.application;

import kbsc.kbsc.domain.reviews.dao.ReviewsRepository;
import kbsc.kbsc.domain.reviews.domain.Review;
import kbsc.kbsc.domain.reviews.dto.ReviewDTO;
import kbsc.kbsc.domain.reviews.dto.WriteReviewDto;
import kbsc.kbsc.domain.user.Repository.UserRepository;
import kbsc.kbsc.domain.user.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {
    final ReviewsRepository reviewsRepository;
    final UserRepository userRepository;

    //후기 작성
    @Transactional
    public Review createReview(WriteReviewDto reviewDto) throws IOException {
        Review reviews = new Review();

        reviews.setUserIdx(reviewDto.getUserIdx());
        reviews.setNanumiIdx(reviewDto.getNanumiIdx());
        reviews.setVital(reviewDto.getVital());
        reviews.setContent(reviewDto.getContent());

        Users nanumi = userRepository.findById(reviewDto.getNanumiIdx()).orElseThrow(IOException::new);
        Users chenumi = userRepository.findById(reviewDto.getUserIdx()).orElseThrow(IOException::new);
        reviews.setNanumiName(nanumi.getUserNickName());
        reviews.setChenumiImageUrl(chenumi.getProfileImgUrl());
        reviews.setChenumiName(chenumi.getUserNickName());

        return reviewsRepository.save(reviews);
    }


    public List<ReviewDTO> getReviewList(Long nanumiIdx) {
        List<Review> reviews = reviewsRepository.findAll();
        List<ReviewDTO> results = new ArrayList<>();
        for (Review review: reviews) {
            ReviewDTO reviewDTO = new ReviewDTO();
            if(review.getNanumiIdx() == nanumiIdx)
            {
                reviewDTO.setContent(review.getContent());
                reviewDTO.setVital(review.getVital());
                reviewDTO.setChenumiNickname(review.getChenumiName());
                reviewDTO.setChenumiImageUrl(review.getChenumiImageUrl());
                results.add(reviewDTO);
            }


        }
        return results;
    }
    
    //받은 후기 목록 조회


}
