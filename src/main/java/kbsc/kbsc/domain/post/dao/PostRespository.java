package kbsc.kbsc.domain.post.dao;

import kbsc.kbsc.domain.post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PostRespository {
    private final EntityManager em;

    @Autowired
    public PostRespository(EntityManager em) {
        this.em = em;
    }

    //게시물 등록
    public Post save(Post post){
        if(post.getPostId() == null){
            em.persist(post);
            return post;
        }
        else{
            em.merge(post);
            return post;
        }
    }
}
