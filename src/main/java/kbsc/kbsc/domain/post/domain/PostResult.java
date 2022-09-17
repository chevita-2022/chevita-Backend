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
        this.detailedLocation = post.getDetailedLocation();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        this.totalHearts = post.getTotalHearts();
        this.isCertificatedReceipt = post.isCertificatedReceipt();
        this.seenNumber = post.getSeenNumber();
        this.imgUrls = new ArrayList<>();
        this.globalLocation = post.getGlobalLocation();
        this.sharingTimeZones = new ArrayList<>();
        this.nanumStatus = post.getNanumStatus();

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
    private boolean isCertificatedReceipt;
    private int seenNumber=0;

    private int reserveIdx;
    private String nanumStatus;
    List<String> imgUrls;

    List<List<String>> sharingTimeZones; //나눔일자 = [[나눔일자, 나눔시간대], [나눔일자, 나눔시간대], [나눔일자, 나눔시간대]]







}
