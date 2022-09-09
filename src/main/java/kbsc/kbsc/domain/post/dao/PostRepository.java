package kbsc.kbsc.domain.post.dao;

import kbsc.kbsc.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom{
}
