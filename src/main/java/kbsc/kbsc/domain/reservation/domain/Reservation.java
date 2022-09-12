package kbsc.kbsc.domain.reservation.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reserveIdx;

    //TODO: user entity 완성되면 연결하기
    private Long userIdx;
    
    //TODO: post 매핑
    private Long postIdx;
    
    private Long takerIdx; //채누미 idx
    private String confirmedSharingTime; //확정된 나눔 시간
    private String nanumStatus; //나눔 상태 default = "not reserved"
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder

    public Reservation(Long reserveIdx, Long userIdx, Long postIdx, Long takerIdx, String confirmedSharingTime, String nanumStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.reserveIdx = reserveIdx;
        this.userIdx = userIdx;
        this.postIdx = postIdx;
        this.takerIdx = takerIdx;
        this.confirmedSharingTime = confirmedSharingTime;
        this.nanumStatus = nanumStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
