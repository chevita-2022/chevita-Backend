package kbsc.kbsc.domain.reviews.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString()
public class WriteReviewDto {

    Long userIdx;
    Long nanumiIdx;

    String nanumiName;

    int vital = 67;
    String content;
}
