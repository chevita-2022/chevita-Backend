package kbsc.kbsc.domain.hashtag.dao;


import kbsc.kbsc.domain.hashtag.domain.Hashtag;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class HashtagRepository {
    private final EntityManager em;


    public HashtagRepository(EntityManager em) {
        this.em = em;
    }

    //해시태그 등록
    public Hashtag save(Hashtag hashtag){
        if (hashtag.getTagIdx()== null){
            hashtag.setTagIdx(hashtag.getTagIdx());
            em.persist(hashtag);
        }
        else {
            em.merge(hashtag);
        }
        em.flush();
        return hashtag;
    }

}
