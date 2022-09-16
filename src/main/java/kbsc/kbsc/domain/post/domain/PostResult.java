package kbsc.kbsc.domain.post.domain;

import kbsc.kbsc.domain.s3.S3Service;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class PostResult {/*
    public PostResult(Post post) {
        this.postIdx = post.getPostIdx();
        this.userIdx = userIdx;
        this.title = title;
        this.contents = contents;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasedAt = purchasedAt;
        this.openedDate = openedDate;
        this.shelfLife = shelfLife;
        this.expirationDate = expirationDate;
        this.storageMethod = storageMethod;
        this.globalLocation = globalLocation;
        this.detailedLocation = detailedLocation;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.totalHearts = totalHearts;
        this.receiptImgUrl = receiptImgUrl;
        this.seenNumber = seenNumber;
        this.imgUrls = new ArrayList<>();
    }*/

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
        this.detailedLocation = post.getDetailedLocation();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        this.totalHearts = post.getTotalHearts();
        this.receiptImgUrl = post.getReceiptImgUrl();
        this.seenNumber = post.getSeenNumber();
        this.imgUrls = new ArrayList<>();
        this.globalLocation = post.getGlobalLocation();
        this.availableDates = new ArrayList<>();

        //Post 칼럼의 reserveIdx??
    }


    private Long postIdx;
    private Long userIdx;
    private String title;
    private String contents;
    private String category;
    private String purchaseDate;
    private String purchasedAt;
    private String  openedDate;
    private String  shelfLife;
    private String expirationDate;
    private String storageMethod;
    private String globalLocation; //기본주소
    private String detailedLocation; //상세 주소
    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;
    private int totalHearts=0;
    private String receiptImgUrl;
    private int seenNumber=0;

    private int reserveIdx;
    List<String> imgUrls;

    List<List<String>> availableDates; //나눔일자 = [[나눔일자, 나눔시간대], [나눔일자, 나눔시간대], [나눔일자, 나눔시간대]]






}
