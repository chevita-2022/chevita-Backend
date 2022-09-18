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
@Table(name = "heartedPost")
public class heartedPost {

    @Id
    private Long heartedIdx;
    private Long userIdx;
    private Long postIdx;


}
