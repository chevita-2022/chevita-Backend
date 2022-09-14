package kbsc.kbsc.domain.reservation.dao;

import kbsc.kbsc.domain.reservation.domain.Reservation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

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

    //reservation Id
}
