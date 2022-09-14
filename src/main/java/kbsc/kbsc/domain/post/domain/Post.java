package kbsc.kbsc.domain.post.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
* ***Entity 클래스를 절대 request/response 클래스로 사용하면 안된다. ***
* */

@Getter //클래스내 모든 필드의 getter 메소드 자동생성
@NoArgsConstructor //기본 생성자 자동 추가, public Post()와 같은 효과
@Entity
@Setter //사용하면 안되는데..
public class Post {
    @Id //해당 테이블의 pk 값
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성 규칙
    private Long postIdx;
    private Long userIdx;

  /* //1:N일 때 외래키는 항상 N쪽에 존재
    @ManyToOne
    //같은 키를 관리하기 때문에 문제 발생 가능성 존재 -> 읽기만 가능하도록 설정
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Long userId;*/

    @Column(length = 30)
    private String title;

    private String contents;

    @Column(length = 30)
    private String category;

    private String purchaseDate;
    private String purchasedAt;

    private String  openedDate;
    private String  shelfLife;

    private String expirationDate;

    @Column(length = 20)
    private String storageMethod;

    private String globalLocation; //기본주소
    private String detailedLocation; //상세 주소

    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;

    private int totalHearts=0;
    private String receiptImgUrl;

    private int seenNumber=0;
    //TODO: 수정하기


    @Builder //해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함 //생성자 대신 사용
    public Post(Long postIdx, Long userIdx, String title, String contents, String category, String purchaseDate, String purchasedAt, String openedDate, String shelfLife, String expirationDate, String storageMethod, String globalLocation, String detailedLocation, LocalDateTime createdAt, LocalDateTime updatedAt, int totalHearts, String receiptImgUrl, int seenNumber) {
        this.postIdx = postIdx;
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
    }
}
