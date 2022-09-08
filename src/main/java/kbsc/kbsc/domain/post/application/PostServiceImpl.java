package kbsc.kbsc.domain.post.application;

import kbsc.kbsc.domain.post.dao.PostRepository;
import kbsc.kbsc.domain.post.dto.PostDto;
import kbsc.kbsc.domain.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor

public class PostServiceImpl implements PostService{
    private final PostRepository postRepository; //이건 왜 만드는교?

    @Override
    public PostDto.CreateResponse createPost(PostDto.CreateRequest createRequest) {

        return null;
    }

    @Override
    public PostDto.UpdateRequest updatePost(PostDto.UpdateRequest updateRequest) {
        return null;
    }

    @Override
    public PostDto.GetDetailResponse getDetailPost(Long postId) {
        return null;
    }

    @Override
    public Post deletePost(Long postId) {
        return null;
    }

    @Override
    public Post validatePostId(Long postId) {
        return null;
    }
}
