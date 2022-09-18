package kbsc.kbsc.domain.heartedPost.dao;

import kbsc.kbsc.domain.heartedPost.domain.HeartedPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeartedPostRepository extends JpaRepository<HeartedPost, Long> {
    Optional<HeartedPost> findHeartedPostByUserIdxAndPostIdx(Long postIdx, Long userIdx);
}
