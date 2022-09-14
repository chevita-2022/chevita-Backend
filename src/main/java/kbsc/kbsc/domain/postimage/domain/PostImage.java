package kbsc.kbsc.domain.postimage.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "PostImage")
public class PostImage {

    //autoincrement로 변경하기
    //TODO:값없다구 그래서 PostImage imgIdx 디폴트값 임시로 넣어둠
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long postImgIdx;

    Long postIdx;
    String imgUrl;

}
