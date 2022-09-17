package kbsc.kbsc.domain.user.dto;

import lombok.*;

//클라이언트쪽에서 입력받은 데이터들 => 우리의 경우 소셜로그인이라 소셜 서버에서 받은 데이터 위주로 저장
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {

    Long userIdx;
    String userNickName;
    String userAddress;
    String profileImgUrl;
}