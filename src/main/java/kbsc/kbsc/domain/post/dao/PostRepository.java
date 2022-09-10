package kbsc.kbsc.domain.post.dao;

import kbsc.kbsc.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Entity클래스, PK타입>
public interface PostRepository extends JpaRepository<Post, Long> {
}
