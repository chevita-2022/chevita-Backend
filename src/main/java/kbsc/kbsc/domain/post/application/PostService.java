package kbsc.kbsc.domain.post.application;

import kbsc.kbsc.domain.post.dao.PostRepository;
import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.post.dto.PostResponseDto;
import kbsc.kbsc.domain.post.dto.PostSaveRequestDto;
import kbsc.kbsc.domain.post.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getPostId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));
        post.update(requestDto.getTitle(), requestDto.getContents());

        return id;
    }

    public PostResponseDto findById(Long id){
        Post entity = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException(
                "해당 게시글이 없습니다. id = "+ id));
        return new PostResponseDto(entity);
    }

}
