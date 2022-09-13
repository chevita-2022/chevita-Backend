package kbsc.kbsc.domain.reservation.api;

import io.swagger.annotations.ApiOperation;
import kbsc.kbsc.domain.reservation.application.ReservationService;
import kbsc.kbsc.domain.reservation.domain.Reservation;
import kbsc.kbsc.domain.reservation.dto.ReservationDto;
import kbsc.kbsc.global.util.BasicResponse;
import kbsc.kbsc.global.util.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {


    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @ApiOperation(value = "나눔 상태 변경", notes = "나눔 상태 변경")
    @PatchMapping("/posts/{postId}/reservation")
    public ResponseEntity<? extends BasicResponse> updateNanumStatus(@PathVariable Long postIdx, @RequestBody ReservationDto reservationDto){
        Reservation resultReservation = reservationService.updateStatus(reservationDto);
        return ResponseEntity.ok().body(new CommonResponse(resultReservation));
    }
}
