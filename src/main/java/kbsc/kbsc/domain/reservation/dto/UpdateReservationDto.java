package kbsc.kbsc.domain.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString()
public class UpdateReservationDto {
    private Long reserveIdx;
    private String nanumStatus; //나눔 상태 default = "not reserved"


}
