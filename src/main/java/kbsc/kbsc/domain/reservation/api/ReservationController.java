package kbsc.kbsc.domain.reservation.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kbsc.kbsc.domain.reservation.application.ReservationService;
import kbsc.kbsc.domain.reservation.domain.Reservation;
import kbsc.kbsc.domain.reservation.dto.ReservationDto;
import kbsc.kbsc.domain.reservation.dto.UpdateReservationDto;
import kbsc.kbsc.global.util.BasicResponse;
import kbsc.kbsc.global.util.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts/reservation")
@RestController
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @ApiOperation(value = "나눔예약요청", notes = "body 안에 넣어줘야하는 값들 \n" +
            "postIdx : 게시글 고유번호\n" +
            "nanumiIdx: 나누미 고유번호\n" +
            "takerIdx: 채누미 고유번호\n" +
            "confirmedSharingTime:  확정된 나눔시간, 디폴트는 기타시간대, 구체적 시간대가 정해지면 넣어주기\n" +
            "nanumStatus: 나눔상태 ")
    @PostMapping
    public ResponseEntity<? extends BasicResponse> requestNanum(@RequestBody ReservationDto reservationDto ){
        Reservation reservation = reservationService.createReservation(reservationDto);
        return ResponseEntity.ok().body(new CommonResponse<>(reservation));
    }

    @GetMapping("/test")
    public List<Reservation> findAllReservation() {
        return reservationService.findAllReservation();
    }
    @ApiOperation(value = "post id로 나눔예약정보 조회", notes = "post id로 나눔예약정보 조회")
    @GetMapping("/{postid}")
    public ResponseEntity<? extends BasicResponse> getReservationByPostId(@PathVariable Long postid ){
        Reservation reservation = reservationService.getSingleReservation(postid);
        return ResponseEntity.ok().body(new CommonResponse<>(reservation));
    }

    @ApiOperation(value = "나눔상태변경", notes = "나눔상태변경")
    @PatchMapping
    public ResponseEntity<? extends BasicResponse> updateReservationStatus(@RequestBody UpdateReservationDto reservationDto){
        Reservation reservation = reservationService.updateReservation(reservationDto);
        return ResponseEntity.ok().body(new CommonResponse<>(reservation));
    }

}
