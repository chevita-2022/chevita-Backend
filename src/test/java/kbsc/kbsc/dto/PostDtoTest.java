package kbsc.kbsc.dto;

import kbsc.kbsc.domain.post.dto.PostDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PostDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        PostDto dto = new PostDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
