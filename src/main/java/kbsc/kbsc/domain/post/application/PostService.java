package kbsc.kbsc.domain.post.application;

import kbsc.kbsc.domain.post.dao.PostRepository;
import kbsc.kbsc.domain.post.dto.PostSaveRequestDto;
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
}
