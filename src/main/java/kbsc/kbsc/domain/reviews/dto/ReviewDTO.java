package kbsc.kbsc.domain.reviews.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString()
public class ReviewDTO {
    String content;
    String chenumiNickname;
    int vital;
    String chenumiImageUrl;
}
