package kbsc.kbsc.domain.post.application;

import kbsc.kbsc.domain.post.dao.PostConnectionRepository;
import kbsc.kbsc.domain.post.dao.PostRepository;
import kbsc.kbsc.domain.post.dto.PostDto;
import kbsc.kbsc.domain.post.dto.PostMapper;
import kbsc.kbsc.domain.post.dto.PostMapperSupport;
import kbsc.kbsc.domain.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor

//TODO: return 값 모두 수정필요
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository; //이건 왜 만드는교?
    private final PostConnectionRepository postConnectionRepository;
    private final PostMapper postMapper;
    private final PostMapperSupport postMapperSupport;

    @Override
    public PostDto.CreateResponse createPost(PostDto.CreateRequest createRequest) {
        Post post = this.postMapper.toEntity(createRequest);
        return this.postMapper.toCreateResponse(this.postRepository.save(post));
    }

    @Override
    public PostDto.UpdateResponse updatePost(PostDto.UpdateRequest updateRequest) {
        return null;
    }

    @Override
    public PostDto.GetDetailResponse getDetailPost(Long postId) {
        Optional<Post> post = this.postRepository.findNotDeletedByBoardId(postId);
//        Optional<List<PostConnection>>
        
        return null;
    }

    /*private Post validatePostId(Long postId) {
//        return this.postRepository;
    }*/

    @Override
    public Post deletePost(Long postId) {
        return null;
    }


}
