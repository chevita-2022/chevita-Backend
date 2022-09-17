package kbsc.kbsc.domain.reservation.dao;

import kbsc.kbsc.domain.reservation.domain.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Repository
public class ReservationRepository {
    private final EntityManager em;

    public ReservationRepository(EntityManager em) {
        this.em = em;
    }

    //예약 등록
    public Reservation save(Reservation reservation){
        if(reservation.getReserveIdx()== null){
            reservation.setReserveIdx(reservation.getReserveIdx());
            em.persist(reservation);
        }
        else{
            em.merge(reservation);
        }
        em.flush();
        return reservation;
    }
    //postid로 특정 게시물 조회
    public Reservation findByPostId(Long postId) {
        Reservation reserva = em.find(Reservation.class, postId);
        return reserva;
    }

    //reservationId로 특정 예약 조회
    public Reservation findByReservationId(Long reservationId) {
        Reservation reservation = em.find(Reservation.class, reservationId);
        return reservation;
    }

    public List<Reservation> findAll() {
        List<Reservation> list = em.createQuery("select m from Reservation m", Reservation.class)
                .getResultList();
        log.info("list.get(0))={}", list.get(0));
        return em.createQuery("select m from Reservation m", Reservation.class)
                .getResultList();
    }
}
