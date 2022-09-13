package kbsc.kbsc.domain.reservation.domain;

import kbsc.kbsc.domain.post.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private Long reserveIdx;

    //TODO: user entity 완성되면 연결하기
    private Long userIdx;

//    @OneToOne(mappedBy = "reservation")
//    private Post post;
    
    private Long takerIdx; //채누미 idx
    private String confirmedSharingTime; //확정된 나눔 시간
    private String nanumStatus; //나눔 상태 default = "not reserved"
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Reservation(Long reserveIdx, Long userIdx, Long takerIdx, String confirmedSharingTime, String nanumStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.reserveIdx = reserveIdx;
        this.userIdx = userIdx;
        this.takerIdx = takerIdx;
        this.confirmedSharingTime = confirmedSharingTime;
        this.nanumStatus = nanumStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
