package kbsc.kbsc.domain.post.application;

import kbsc.kbsc.domain.post.dto.PostDto;
import kbsc.kbsc.domain.post.dto.PostDto.*;
import kbsc.kbsc.domain.post.entity.Post;
import org.springframework.stereotype.Service;

//component 스캔을 통해 자동으로 bean으로 등록
//비즈니스 로직을 처리하는 클래스
//데이터베이스 트랜잭션 처리 진행
public interface PostService {
    CreateResponse createPost(CreateRequest createRequest);
    UpdateResponse updatePost(UpdateRequest updateRequest);
    GetDetailResponse getDetailPost(Long postId);
    Post deletePost(Long postId);

    //   PaginationDto<List<GetAllResponse>> getAllDetailBoards(Pageable pageable, String boardType);

    //검증 부분
//    Post validatePostId(Long postId);
//    void validateCreatedUser(Post post);
}
