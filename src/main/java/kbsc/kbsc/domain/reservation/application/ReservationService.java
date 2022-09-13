package kbsc.kbsc.domain.reservation.application;
import kbsc.kbsc.domain.reservation.dao.ReservationRepository;
import kbsc.kbsc.domain.reservation.domain.Reservation;
import kbsc.kbsc.domain.reservation.dto.ReservationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    //예약 요청이 들어오면 예약 테이블 생성
    @Transactional
    public Reservation updateStatus(ReservationDto reservationDto){
        Reservation reserve = new Reservation();

//        reserve.setReserveIdx(reserve.getReserveIdx());
        reserve.setUserIdx(reserve.getUserIdx());
//        reserve.setPost(reserve.getPost());
        reserve.setTakerIdx(reserve.getTakerIdx());
        reserve.setConfirmedSharingTime(reserve.getConfirmedSharingTime());
        reserve.setCreatedAt(reserve.getUpdatedAt());
        reserve.setUpdatedAt(reserve.getUpdatedAt());

        return reservationRepository.save(reserve);
    }

}
