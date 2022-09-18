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
    int vital;
    String content;
}
