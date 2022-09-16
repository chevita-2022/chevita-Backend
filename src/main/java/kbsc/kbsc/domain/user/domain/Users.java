package kbsc.kbsc.domain.user.domain;

import lombok.*;

import javax.persistence.*;

//데이터베이스 테이블과 1:1 맵핑되도록 구성


//User라는 이름의 table 생성해줌 -> 우린 이미 테이블 있어서 어노테이션 제외함

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Users")
public class Users {

    //pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    Long userIdx;

    String userNickName;
    String userAddress;
    String profileImgUrl;
    Long vital;
    //TODO: vital 값 계산하는 부분 필요?


}