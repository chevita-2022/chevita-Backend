package kbsc.kbsc.domain.hashtag.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    Long tagIdx;
    String tagName; //'가공식품/베이커리/식빵 등 사용자 지정 해시태그'

}
