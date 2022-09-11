package kbsc.kbsc.domain.login.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class KakaoUserDto {

    private String kakaoAccount;
    private String properties;
    private String id;
    private String nickname;
    private String age_range;
}
