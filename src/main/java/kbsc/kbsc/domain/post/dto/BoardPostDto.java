package kbsc.kbsc.domain.post.dto;

import kbsc.kbsc.domain.post.domain.Post;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardPostDto {
    private Long postId;
    private Long userId;
    private String title;
    private String contents;

    public Post createBoard(){
        return Post.builder()
                .userIdx(userId)
                .title(title)
                .contents(contents)
                .build();
    }

    @Builder
    public BoardPostDto(Long postId, Long userId, String title, String contents) {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
    }
}
