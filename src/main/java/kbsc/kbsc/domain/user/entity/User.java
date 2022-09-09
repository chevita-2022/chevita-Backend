package kbsc.kbsc.domain.user.entity;

import kbsc.kbsc.domain.post.entity.Post;
import kbsc.kbsc.domain.post.entity.PostConnection;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Data
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor  //기본 생성자 자동 추가, public Post()와 같은 효과
@AllArgsConstructor
@ToString
//TODO: Users entity 채워넣기
// https://github.com/SoohyeonB/23ideal-Backend/blob/master/src/main/java/com/example/itaminbackend/domain/user/entity/User.java
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column
    private String userNickName;
    @Column
    private String userAddress;
    @Column
    private String profileImgUrl;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;
    @Column
    private String introduction;
    @Column
    private float vital = 0;
    @Column
    private String userhashTag;


    @OneToMany
    @JoinColumn(name="user_id")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<PostConnection> postConnections = new ArrayList<>();
    @Builder
    public User(String userNickName, String userAddress, String profileImgUrl){
        this.userNickName = userNickName;
        this.userAddress = userAddress;
        this.profileImgUrl = profileImgUrl;
    }

    public User update(String userNickName, String profileImgUrl) {
        this.userNickName = userNickName;
        this.profileImgUrl = profileImgUrl;
        return this;
    }

    public void setPosts(Post post){
        this.posts.add(post);
        post.setUser(this);
    }

}
