package kbsc.kbsc.domain.postimage.Repository;

import kbsc.kbsc.domain.postimage.domain.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostImageRepository extends JpaRepository<PostImage, Long> {
}
