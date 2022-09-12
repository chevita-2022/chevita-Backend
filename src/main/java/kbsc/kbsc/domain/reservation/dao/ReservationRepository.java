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
            em.persist(reservation);
        }
        else{
            em.merge(reservation);
        }
        em.flush();
        return reservation;
    }
}
