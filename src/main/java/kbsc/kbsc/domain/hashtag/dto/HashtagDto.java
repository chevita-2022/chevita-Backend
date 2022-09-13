package kbsc.kbsc.domain.hashtag.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString()
public class HashtagDto {
    Long tagIdx;
    String tagName; //'가공식품/베이커리/식빵 등 사용자 지정 해시태그'
}
