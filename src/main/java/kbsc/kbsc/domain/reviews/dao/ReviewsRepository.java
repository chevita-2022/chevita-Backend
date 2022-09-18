package kbsc.kbsc.domain.reviews.dao;

import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.reviews.domain.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewsRepository{
    private final EntityManager em;

    public ReviewsRepository(EntityManager em) {
        this.em = em;
    }

    //리뷰 등록
    public Reviews save(Reviews reviews){
        if(reviews.getReviewIdx() == null){
            reviews.setReviewIdx(reviews.getReviewIdx());
            em.persist(reviews);
        }
        else {
            em.merge(reviews);
        }
        em.flush();
        return reviews;
    }

    //reviewId로 특정 후기 조회
    public Reviews findByReviewId(Long reviewId) {
        Reviews result = em.find(Reviews.class, reviewId);
        return result;
    }


    //userId로 사용자의 특정 리뷰 조회
    public List<Reviews> findByUserId(Long userId) throws NoResultException {
        List<Reviews> reviews = (List<Reviews>) em.find(Reviews.class, userId);
        return reviews;
    }

}
