package kbsc.kbsc.dto;

import kbsc.kbsc.domain.post.dto.PostDto;
import org.junit.Test;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
@WebAppConfiguration
public class PostDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
//        PostDto dto = new PostDto(name, amount);

        //then
//        assertThat(dto.getName()).isEqualTo(name);
//        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
