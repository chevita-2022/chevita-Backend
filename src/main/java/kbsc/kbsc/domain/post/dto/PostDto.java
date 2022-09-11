package kbsc.kbsc.domain.post.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class PostDto {
    private Long postId;                // 이 필드는 게시글 수정때문에 유지함.
    private Long userId;                // 게시글 작성자 id
    private String content;
    private String title;

    public String toString(){
        return "PostDto{"+
                ", postId = "+postId+
                ", userId = "+userId+
                ", title = "+title +
                ", content = "+content+
                "}";
    }
}
