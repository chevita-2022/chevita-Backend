package kbsc.kbsc.domain.post.dao;

import kbsc.kbsc.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
}
