package kbsc.kbsc.domain.post.dto;

import kbsc.kbsc.domain.post.domain.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long postId;
    private String title;
    private String category;

    public PostResponseDto(Post entity) {
        this.postId= entity.getPostId();
        this.title= entity.getTitle();
        this.category = entity.getCategory();
    }
}
