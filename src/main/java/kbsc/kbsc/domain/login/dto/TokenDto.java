package kbsc.kbsc.domain.login.dto;

import lombok.Getter;
import lombok.Setter;

//TODO: DTO말고 token, kakaoUser을 domain 변경해야할지 고민해보기
@Getter
public class TokenDto {

    private String access_token;
    private String refresh_token;

}
