package kbsc.kbsc.domain.user.dto;

import kbsc.kbsc.domain.post.domain.Post;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

//클라이언트쪽에서 입력받은 데이터들 => 우리의 경우 소셜로그인이라 소셜 서버에서 받은 데이터 위주로 저장
@Data
@NoArgsConstructor
@ToString
public class UserDto {

    //TODO: 소셜 로그인시 바로 entity 활용해서 Service에서 데이터 추가한 후에 db에 접근할지 따로 dto를 둘지 결정하기
    //TODO: 소셜 로그인시 소셜 서버에서 받은 데이터로 필드 구성하기
    //TODO:toEntity 메소드 작성하기
    private Long userIdx;
    private List<Post> postList = new ArrayList<>();
    private String userNickName;
    private String userAddress;
    private String profileImgUrl;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String introduction;
    private float vital;
    private String userhashTag;

    @Override
    public String toString() {
        return "UserDto{" +
                "userIdx=" + userIdx +
                ", postList=" + postList +
                ", userNickName='" + userNickName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", profileImgUrl='" + profileImgUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", introduction='" + introduction + '\'' +
                ", vital=" + vital +
                ", userhashTag='" + userhashTag + '\'' +
                '}';
    }
}