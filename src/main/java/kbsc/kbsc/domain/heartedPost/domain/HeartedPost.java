package kbsc.kbsc.domain.heartedPost.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "HeartedPost")
public class HeartedPost {

    @Id
    private Long heartedIdx;

    private Long postIdx;
    private Long userIdx;



}
