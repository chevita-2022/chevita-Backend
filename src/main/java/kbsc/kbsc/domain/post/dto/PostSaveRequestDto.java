package kbsc.kbsc.domain.post.dto;

import kbsc.kbsc.domain.post.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String category;
    /*
    private LocalDateTime purchaseDate;
    private String purchasedAt;
    private LocalDateTime  openedDate;
    private LocalDateTime  shelfLife;
    private int expirationDate =15;
    private String storageMethod;
    private String hashtag;
//  사진추가
    private String imgUrl;
    private String receiptImgUrl;
    private String contents;

    private int sharingPlace_x;
    private int sharingPlace_y;
    private String detailedLocation;

    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;*/


   /* @Builder
    public PostSaveRequestDto(String title, String category){//, LocalDateTime purchaseDate, String purchasedAt, LocalDateTime openedDate, LocalDateTime shelfLife, int expirationDate, String storageMethod, String hashtag, String imgUrl, String receiptImgUrl, String contents, int sharingPlace_x, int sharingPlace_y, String detailedLocation, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.category = category;
        /*
        this.purchaseDate = purchaseDate;
        this.purchasedAt = purchasedAt;
        this.openedDate = openedDate;
        this.shelfLife = shelfLife;
        this.expirationDate = expirationDate;
        this.storageMethod = storageMethod;
        this.imgUrl = imgUrl;
        this.receiptImgUrl = receiptImgUrl;
        this.contents = contents;
        this.hashtag = hashtag;
        this.sharingPlace_x = sharingPlace_x;
        this.sharingPlace_y = sharingPlace_y;
        this.detailedLocation = detailedLocation;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    } */

    @Builder
    public PostSaveRequestDto(String title, String category){
        this.title = title;
        this.category = category;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .category(category)
                .build();
        /*
                .purchaseDate(purchaseDate)
                .purchasedAt(purchasedAt)
                .openedDate(openedDate)
                .shelfLife(shelfLife)
                .expirationDate(expirationDate)
                .storageMethod(storageMethod)
                .contents(contents)
                .build();*/
    }
}
