package kbsc.kbsc.domain.post.dao;

import kbsc.kbsc.domain.post.entity.Post;

import java.util.Optional;

public interface PostRepositoryCustom {
    Optional<Post> findNotDeletedByBoardId(Long boardId);
//    Page<GetAllResponse> findAllDetailBoardsByCreatedDate(Pageable pageable, String boardType);
}