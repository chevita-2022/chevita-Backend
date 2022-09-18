package kbsc.kbsc.domain.heartedPost.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HeartedPostDTO {
    private Long postIdx;
    private Long userIdx;
}
