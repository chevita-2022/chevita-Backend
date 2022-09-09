package kbsc.kbsc.domain.post.dao;

import kbsc.kbsc.domain.post.entity.Post;
import kbsc.kbsc.domain.post.entity.PostConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //TODO:뭐하는 코드인지.. 모르겠다..
public interface PostConnectionRepository extends JpaRepository<PostConnection, Long> {
    Optional<List<PostConnection>> findByPost_PostId(Long postId);

    //@Query("select count(*) from PostConnection bc where bc.post = :post")
    Optional<Integer> findConnectionCountByPost(Post post);

}
