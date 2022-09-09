package kbsc.kbsc.domain.post.entity;

import kbsc.kbsc.domain.user.entity.User;
import kbsc.kbsc.global.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor //기본 생성자 자동 추가, public Post()와 같은 효과
@AllArgsConstructor
@Builder
public class Post extends BaseTimeEntity {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postIdx;

    //1:N일 때 외래키는 항상 N쪽에 존재
    @ManyToOne(fetch = FetchType.LAZY)
    //같은 키를 관리하기 때문에 문제 발생 가능성 존재 -> 읽기만 가능하도록 설정
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(nullable = false, length = 30)
    private String category;
    
    @Column(nullable = false)
    private LocalDateTime purchaseDate;
    private String purchasedAt; // 식품 구매처
    
    @Column(nullable = false)
    private LocalDateTime  openedDate;
    private LocalDateTime  shelfLife;

    @Column(nullable = false)
    private int expirationDate =15;

    @Column(nullable = false, length = 20)
    private String storageMethod;

    @Column(nullable = false)
    private String contents;

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
    private int seenNumber=0;

    //이 부분은 뭐하는 코드인지 모르겠음...
    @OneToMany(mappedBy = "post", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<PostConnection> postConnections = new ArrayList<>();




    @Builder
    public Post(String title,String contents){
        //todo: 인자가 너무 많아져서 일단 두개만 설정-> 인자 설정
        this.title = title;
        this.contents = contents;

    }

    //연관관계 매핑
    // 이미지 리턴 https://lazymankook.tistory.com/74
    /*public void setImages(List<Image> images){
        this.images = images;
        for (Image image : images) {
            image.setBoard(this);}
    }*/

    public void setUser(User user) {
        this.user = user;
        user.getPosts().add(this);
    }



}
