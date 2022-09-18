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
    private String purchaseDate;
    private String purchasedAt;
    private String  openedDate; //개봉일자
    private String  shelfLife; //유통기한
    private String expirationDate; //소비기한
    private String storageMethod;

    private String globalLocation; //일반 주소
    private String detailedLocation; //상세 주소
    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;
    private int totalHearts=0;
    private boolean isCertificatedReceipt;
    private int seenNumber=0;
    private List<String> imgUrls;
    private List<List<String>> sharingTimeZones;

    private String nanumStatus ="예약 없음"; //나눔상태
    private List<String> hashtags;

}
