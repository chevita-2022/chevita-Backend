package kbsc.kbsc.domain.reviews.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue()
    Long reviewIdx;


    Long userIdx;
    Long nanumiIdx;
    String nanumiName;
    String chenumiImageUrl;
    String chenumiName;
    int vital;
    String content;
}
