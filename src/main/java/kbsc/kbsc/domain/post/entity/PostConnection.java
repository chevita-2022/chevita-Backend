package kbsc.kbsc.domain.post.entity;

import kbsc.kbsc.domain.user.entity.User;
import kbsc.kbsc.global.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostConnection extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postConnectionId; //이게 뭘까....

    @ManyToOne(fetch = FetchType.LAZY) //jpa 지연로딩 -연관된 쿼리를 실제로 사용할 때 쿼리를 날리게끔 하는 지연로딩
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //엔티티 생성 메서드
    public static PostConnection toEntity(Post post, User user){
        PostConnection postConnection = PostConnection.builder().build();
        postConnection.setPost(post);
        postConnection.setUser(user);
        return postConnection;
    }

    //양방향 연관관계
    public void setPost(Post post){
        this.post = post;
        post.getPostConnections().add(this);
    }

    public void setUser(User user){
        this.user = user;
        user.getPostConnections().add(this);
    }



}
