package kbsc.kbsc.domain.heartedPost.dao;

import kbsc.kbsc.domain.heartedPost.domain.heartedPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartedPostRepository extends JpaRepository<heartedPost, Long> {
}
