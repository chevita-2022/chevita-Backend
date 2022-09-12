package kbsc.kbsc.domain.post.dto;

import kbsc.kbsc.domain.user.domain.Users;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {
    private Long postId;                // 이 필드는 게시글 수정때문에 유지함.
    private Users user;
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




    public String toString(){
        return "PostDto{"+
                ", postId = "+postId+
                ", userId = "+user+
                ", title = "+title +
                ", content = "+content+
                ", category = "+category+
                ", purchaseDate = "+ purchaseDate+
                ", purchasedAt = "+ purchasedAt+
                ", openedDate = " + openedDate +
                ", shelfLife = " + shelfLife+
                ", expirationDate = "+ expirationDate+
                ", storageMethod = " + storageMethod+
                ", sharingPlace_x = " + sharingPlace_x+
                ", sharingPlace_y = " + sharingPlace_y+
                ", detailedLocation = " + detailedLocation+
                ", createdAt = "+ createdAt+
                ", updatedAt = "+ updatedAt+
                ", totalHearts = " + totalHearts+
                ", receiptImgUrl = "+ receiptImgUrl+
                ", seenNumber = " + seenNumber+
                "}";
    }
}
