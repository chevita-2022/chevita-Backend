package kbsc.kbsc.domain.reviews.dao;

import kbsc.kbsc.domain.reviews.domain.Review;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ReviewsRepository{
    private final EntityManager em;

    public ReviewsRepository(EntityManager em) {
        this.em = em;
    }

    //리뷰 등록
    public Review save(Review reviews){
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

    public List<Review> findAll() {
        /*
        * List<Reservation> list = em.createQuery("select m from Reservation m", Reservation.class)
                .getResultList();
        * */
        List<Review> reviews = em.createQuery("select r from Review r", Review.class)
                .getResultList();
        return reviews;

    }
/*

    //reviewId로 특정 후기 조회
    public ReceivedReview findByReviewId(Long reviewId) {
        ReceivedReview result = em.find(ReceivedReview.class, reviewId);
        return result;
    }


    //userId로 사용자의 특정 리뷰 조회
    public List<ReceivedReview> findByUserId(Long userId) throws NoResultException {
        List<ReceivedReview> reviews = (List<ReceivedReview>) em.find(ReceivedReview.class, userId);
        return reviews;
    }
*/

}
