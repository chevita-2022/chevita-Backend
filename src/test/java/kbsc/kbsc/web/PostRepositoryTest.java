package kbsc.kbsc.web;
import kbsc.kbsc.domain.post.domain.Post;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //h2 자동 실행
public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @After
    public void cleanup(){ //테스트 코드가 영향을 못미치게 매번 전체 repository를 비우는 코드
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String category = "테스트 분류";

        postRepository.save(Post
                .builder()
                .title(title)
                .category(category)
                .build());


        //when
        List<Post> postList = postRepository.findAll();
        
        //then
        Post post = postList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getCategory()).isEqualTo(category);



    }

}
