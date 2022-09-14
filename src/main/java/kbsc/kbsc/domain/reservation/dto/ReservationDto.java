package kbsc.kbsc.domain.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString()
public class ReservationDto {

    private Long reserveIdx;
    private Long postIdx;

    private Long takerIdx; //채누미 idx
    private Long nanumiIdx; //나누미 idx

    private String confirmedSharingTime = "기타 시간대"; //default: 기타 시간대 확정된 나눔 시간
    private String nanumStatus= "not reserved"; //나눔 상태 default = "not reserved"
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
