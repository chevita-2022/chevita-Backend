package kbsc.kbsc.domain.post.application;

import kbsc.kbsc.domain.post.dto.PostDto;
import kbsc.kbsc.domain.post.dto.PostDto.*;
import kbsc.kbsc.domain.post.entity.Post;
import org.springframework.stereotype.Service;

@Service //component 스캔을 통해 자동으로 bean으로 등록
//비즈니스 로직을 처리하는 클래스
//데이터베이스 트랜잭션 처리 진행
public interface PostService {
    CreateResponse createPost(CreateRequest createRequest);
    UpdateRequest updatePost(UpdateRequest updateRequest);
    GetDetailResponse getDetailPost(Long postId);
    Post deletePost(Long postId);

    //페이징 정보를 담은 dto
    //PaginationDto<List<GetAllResponse>> getAllDetailBoards(Pageable pageable, String boardType);

    Post validatePostId(Long postId);


    //void validateCreatedUser(Post post);
}
