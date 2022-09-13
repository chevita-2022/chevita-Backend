package kbsc.kbsc.domain.post.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString()
public class PostDto {
    private Long postId;                // 이 필드는 게시글 수정때문에 유지함.
    private Long userId;                // 게시글 작성자 id
    private String title;
    private String content;
    private String category;
    private LocalDateTime purchaseDate;
    private String purchasedAt;
    private LocalDateTime  openedDate; //개봉일자
    private LocalDateTime  shelfLife; //유통기한
    private int expirationDate =15; //소비기한
    private String storageMethod;
    private int sharingPlace_x;
    private int sharingPlace_y;
    private String detailedLocation;
    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;
    private int totalHearts=0;
    private String receiptImgUrl;
    private int seenNumber=0;
    private List<String> imgUrls;
}
