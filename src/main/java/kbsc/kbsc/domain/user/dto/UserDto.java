package kbsc.kbsc.domain.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//클라이언트쪽에서 입력받은 데이터들 => 우리의 경우 소셜로그인이라 소셜 서버에서 받은 데이터 위주로 저장
@Data
@NoArgsConstructor
@ToString
@Builder
public class UserDto {

    //TODO: 소셜 로그인시 바로 entity 활용해서 Service에서 데이터 추가한 후에 db에 접근할지 따로 dto를 둘지 결정하기
    //TODO: 소셜 로그인시 소셜 서버에서 받은 데이터로 필드 구성하기
    //TODO:toEntity 메소드 작성하기


}
