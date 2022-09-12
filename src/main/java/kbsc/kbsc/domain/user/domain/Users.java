package kbsc.kbsc.domain.user.domain;

import kbsc.kbsc.domain.post.domain.Post;
import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

//데이터베이스 테이블과 1:1 맵핑되도록 구성


//User라는 이름의 table 생성해줌 -> 우린 이미 테이블 있어서 어노테이션 제외함

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Users")
public class Users { //Team, Pocket

    //pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    Long userIdx;

    @OneToMany(mappedBy = "post")
    private List<Post> postList = new ArrayList<>();

    String userNickName;
    String userAddress;
    String profileImgUrl;
    Timestamp createdAt;
    Timestamp updatedAt;
    String introduction;
    float vital;
    //TODO: db에서 userHashTag가 아니라 userhashTag라서 이렇게 일단 만듦
    String userhashTag;


}