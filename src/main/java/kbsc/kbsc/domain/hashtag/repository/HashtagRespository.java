package kbsc.kbsc.domain.hashtag.repository;

import kbsc.kbsc.domain.hashtag.domain.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRespository extends JpaRepository<Hashtag, String> {
}
