package kbsc.kbsc.domain.postimage.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PostImage")
public class PostImage {

    //autoincrement로 변경하기
    //TODO:값없다구 그래서 PostImage imgIdx 디폴트값 임시로 넣어둠
    @Id
    Long imgIdx;

    Long postIdx;
    String imgUrl;

}
