package kbsc.kbsc.domain.post.domain;

import kbsc.kbsc.domain.s3.S3Service;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PostResult {


    public PostResult(Post post) {
        this.postIdx = post.getPostIdx();
        this.userIdx = post.getUserIdx();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.category = post.getCategory();
        this.purchaseDate = post.getPurchaseDate();
        this.purchasedAt = post.getPurchasedAt();
        this.openedDate = post.getOpenedDate();
        this.shelfLife = post.getShelfLife();
        this.expirationDate = post.getExpirationDate();
        this.storageMethod = post.getStorageMethod();
        this.sharingPlace_x = post.getSharingPlace_x();
        this.sharingPlace_y = post.getSharingPlace_y();
        this.detailedLocation = post.getDetailedLocation();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        this.totalHearts = post.getTotalHearts();
        this.receiptImgUrl = post.getReceiptImgUrl();
        this.seenNumber = seenNumber;
        this.imgUrls = new ArrayList<>();
    }

    private Long postIdx;
    private Long userIdx;
    private String title;
    private String contents;
    private String category;

    private LocalDateTime purchaseDate;
    private String purchasedAt;

    private LocalDateTime  openedDate;
    private LocalDateTime  shelfLife;

    private int expirationDate;
    private String storageMethod;

    private int sharingPlace_x;

    private int sharingPlace_y;

    private String detailedLocation;

    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;
    private int totalHearts=0;
    private String receiptImgUrl;
    private int seenNumber=0;

    List<String> imgUrls;



}
