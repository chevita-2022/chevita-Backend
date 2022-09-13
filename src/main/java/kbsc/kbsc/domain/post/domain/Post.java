package kbsc.kbsc.domain.post.domain;

import kbsc.kbsc.domain.hashtag.domain.Hashtag;
import kbsc.kbsc.domain.reservation.domain.Reservation;
import lombok.*;

import javax.persistence.*;
import javax.swing.text.html.HTML;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
* ***Entity 클래스를 절대 request/response 클래스로 사용하면 안된다. ***
* */

@Getter //클래스내 모든 필드의 getter 메소드 자동생성
@NoArgsConstructor //기본 생성자 자동 추가, public Post()와 같은 효과
@Entity
@Setter //사용하면 안되는데..
public class Post {
    @Id //해당 테이블의 pk 값
    @Column(name = "POSTIDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성 규칙
    private Long postIdx;
    private Long userIdx;

    @ManyToMany
    @JoinTable(name = "POST_HASHTAG",
                joinColumns = @JoinColumn(name = "POSTIDX"),
                inverseJoinColumns = @JoinColumn(name = "TAGIDX"))
    private List<Hashtag> hashtags = new ArrayList<>();

    /*@OneToOne
    @JoinColumn(name = "RESERVATION_ID")
    private Reservation reservation;*/

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

    private LocalDateTime purchaseDate;
    private String purchasedAt;

    private LocalDateTime  openedDate;
    private LocalDateTime  shelfLife;

    private int expirationDate =15;

    @Column(length = 20)
    private String storageMethod;

    private int sharingPlace_x;

    private int sharingPlace_y;

    private String detailedLocation;

    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;

    private int totalHearts=0;
    private String receiptImgUrl;

    private int seenNumber=0;

    @Builder
    public Post(Long postIdx, Long userIdx, List<Hashtag> hashtags, String title, String contents, String category, LocalDateTime purchaseDate, String purchasedAt, LocalDateTime openedDate, LocalDateTime shelfLife, int expirationDate, String storageMethod, int sharingPlace_x, int sharingPlace_y, String detailedLocation, LocalDateTime createdAt, LocalDateTime updatedAt, int totalHearts, String receiptImgUrl, int seenNumber) {
        this.postIdx = postIdx;
        this.userIdx = userIdx;
        this.hashtags = hashtags;
        this.title = title;
        this.contents = contents;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasedAt = purchasedAt;
        this.openedDate = openedDate;
        this.shelfLife = shelfLife;
        this.expirationDate = expirationDate;
        this.storageMethod = storageMethod;
        this.sharingPlace_x = sharingPlace_x;
        this.sharingPlace_y = sharingPlace_y;
        this.detailedLocation = detailedLocation;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.totalHearts = totalHearts;
        this.receiptImgUrl = receiptImgUrl;
        this.seenNumber = seenNumber;
    }

    /*//연관관계 매핑
    public void setReservation(Reservation reservation){
        this.reservation = reservation;
    }*/
}
