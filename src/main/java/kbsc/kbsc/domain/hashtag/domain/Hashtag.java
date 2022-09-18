package kbsc.kbsc.domain.hashtag.domain;

import jdk.jfr.Enabled;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long tagIdx; //해시태그 키값

    String tagName; //해시태그명
    Long postIdx; //매핑할 게시글 idx

}
