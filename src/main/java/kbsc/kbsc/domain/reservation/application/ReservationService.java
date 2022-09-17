package kbsc.kbsc.domain.reservation.application;
import kbsc.kbsc.domain.reservation.dao.ReservationRepository;
import kbsc.kbsc.domain.reservation.domain.Reservation;
import kbsc.kbsc.domain.reservation.dto.ReservationDto;
import kbsc.kbsc.domain.reservation.dto.UpdateReservationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    //예약 요청이 들어오면 예약 테이블 생성
    @Transactional
    public Reservation createReservation(ReservationDto reservationDto){
        Reservation reserve = new Reservation();
//
//        reserve.setReserveIdx(reservationDto.getReserveIdx());

        reserve.setPostIdx(reservationDto.getPostIdx());
        reserve.setNanumiIdx(reservationDto.getNanumiIdx());
        reserve.setTakerIdx(reservationDto.getTakerIdx());
        reserve.setConfirmedSharingTime(reservationDto.getConfirmedSharingTime());
        reserve.setNanumStatus(reservationDto.getNanumStatus());

        return reservationRepository.save(reserve);
    }

    public Reservation getSingleReservation(Long postId) {
        return reservationRepository.findByPostId(postId);
    }

    @Transactional
    public Reservation updateReservation(UpdateReservationDto reservationDto) {
        Long reservationId = reservationDto.getReserveIdx();
        Reservation reservation = reservationRepository.findByReservationId(reservationId);
        /*reservation.setUserIdx(reservationDto.getNanumiIdx());
        reservation.setTakerIdx(reservationDto.getTakerIdx());
        reservation.setPostIdx(reservationDto.getPostIdx());*/
        reservation.setNanumStatus(reservationDto.getNanumStatus());
        return reservationRepository.save(reservation);
    }


}
