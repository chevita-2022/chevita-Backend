package kbsc.kbsc.domain.post.application;

import kbsc.kbsc.domain.post.dao.PostRepository;
import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.post.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    //게시글 업로드
    @Transactional
    public Post createPostByUser(PostDto userPostDto){ //TODO: userid 연결해야함
        Post newPost = new Post();
        newPost.setUserId(userPostDto.getUserId());
        newPost.setTitle(userPostDto.getTitle());
        newPost.setContents(userPostDto.getContent());
        return postRepository.save(newPost);

    }

}
