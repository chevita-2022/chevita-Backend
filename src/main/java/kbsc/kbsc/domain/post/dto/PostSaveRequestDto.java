package kbsc.kbsc.domain.post.dto;

import kbsc.kbsc.domain.post.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String contents;

    @Builder
    public PostSaveRequestDto(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .contents(contents)
                .build();
    }
}
