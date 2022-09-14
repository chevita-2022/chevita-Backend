package kbsc.kbsc.domain.reservation.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reserveIdx;

    private Long nanumiIdx;
    
    //TODO: post 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postIdx;
    
    private Long takerIdx; //채누미 idx
    private String confirmedSharingTime; //확정된 나눔 시간
    private String nanumStatus; //나눔 상태 default = "not reserved"
    //초기상태/예약요청/예약확정/나눔완료
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
