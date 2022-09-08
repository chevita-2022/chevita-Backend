package kbsc.kbsc.domain.user.entity;

import kbsc.kbsc.domain.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor //기본 생성자 자동 추가, public Post()와 같은 효과
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userIdx;


    @OneToMany
    @JoinColumn(name="user_id")
    private List<Post> posts = new ArrayList<>();

}
