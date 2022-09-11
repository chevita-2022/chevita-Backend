package kbsc.kbsc.domain.post.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/*
* ***Entity 클래스를 절대 request/response 클래스로 사용하면 안된다. ***
* */

@Getter //클래스내 모든 필드의 getter 메소드 자동생성
@NoArgsConstructor //기본 생성자 자동 추가, public Post()와 같은 효과
@Entity
@Setter //사용하면 안되는데...
//@Table(name="Post")
public class Post {
    @Id //해당 테이블의 pk 값
    @Column(name = "postIdx")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성 규칙
    private Long postId;
    @Column(name = "userIdx")
    private Long userId;

  /* //1:N일 때 외래키는 항상 N쪽에 존재
    @ManyToOne
    //같은 키를 관리하기 때문에 문제 발생 가능성 존재 -> 읽기만 가능하도록 설정
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;*/

    @Column(length = 30, nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;
/*
    @Column(nullable = false, length = 30)
    private String category;
    /*
    @Column(nullable = false)
    private LocalDateTime purchaseDate;
    private String purchasedAt;

    @Column(nullable = false)
    private LocalDateTime  openedDate;
    private LocalDateTime  shelfLife;

    @Column(nullable = false)
    private int expirationDate =15;

    @Column(nullable = false, length = 20)
    private String storageMethod;



    @Column(nullable = false)
    private int sharingPlace_x;

    @Column(nullable = false)
    private int sharingPlace_y;

    @Column(nullable = false)
    private String detailedLocation;

    @Column(nullable = false)
    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;

    @Column(nullable = false)
    private int totalHearts=0;
    private String receiptImgUrl;

    @Column(nullable = false)
    private int seenNumber=0;*/

    @Builder //해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함 //생성자 대신 사용
    public Post(Long postId, Long userId, String title, String contents) {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
    }


/*    public void update(String title, String category) {
        this.title = title;
        this.category = category;
    }*/
}
