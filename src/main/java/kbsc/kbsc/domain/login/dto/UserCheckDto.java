package kbsc.kbsc.domain.login.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCheckDto {

    private Long userIdx;
    private boolean isExistingUser;

}
