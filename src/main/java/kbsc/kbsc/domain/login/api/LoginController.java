package kbsc.kbsc.domain.login.api;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users/login")
public class LoginController {

    @ResponseBody
    @GetMapping("/kakao")
    public void loginKakao(@RequestParam String code) {
        log.info("kakao code={}", code);
    }


    //TODO: naver, google 소셜 로그인 컨트롤러 코드 작성
    @GetMapping("/google")
    public void loginGoogle(@RequestParam String code) {
        log.info("google code={}", code);
    }

    @GetMapping("/naver")
    public void loginNaver(@RequestParam String code) {
        log.info("naver code={}", code);
    }





}
