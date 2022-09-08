package kbsc.kbsc.domain.post.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostDto {
    private final String name;
    private final int amount;
}
