package kbsc.kbsc.api;

import kbsc.kbsc.domain.post.api.PostController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(SpringRunner.class) //junit과 스프링테스트 연결자역할
@WebMvcTest(controllers = PostController.class)
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc; //웹 api 테스트

    @Test
    public void get_posts가_리턴된다() throws Exception{
        String getPosts = "get posts";

        mockMvc.perform(get("/api/posts"))
                .andExpect(status().isOk());
    }

    @Test
    public void post_dto가_리턴된다() throws Exception{
        String name = "hello";
        int amount=1000;

        mockMvc.perform(
                get("/posts/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                        .andExpect(status().isOk());

    }

}
