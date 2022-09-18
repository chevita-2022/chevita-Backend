package kbsc.kbsc.domain.post.dao;

import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.postimage.Repository.PostImageRepository;
import kbsc.kbsc.domain.user.domain.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class PostRespository {
    private final EntityManager em;

    final PostImageRepository postImageRepository;

    public PostRespository(EntityManager em, PostImageRepository postImageRepository) {
        this.em = em;
        this.postImageRepository = postImageRepository;
    }

    //게시물 등록
    public Post save(Post post){
        if(post.getPostIdx() == null){
            post.setPostIdx(post.getPostIdx());
            em.persist(post);
        }
        else{
            em.merge(post);
        }
        em.flush();
        return post;
    }

    //postid로 특정 게시물 조회
    public Post findByPostId(Long postId) {
        Post result = em.find(Post.class, postId);
        return result;
    }

   //userid로 특정 게시물 조회
    /*public List<Post> findByUserId(Long userId) {
        List<Post> postList = (List<Post>) em.find(Users.class, userId);
        return postList;
    }*/

    //게시글 전체 조회
    public List<Post> findAll() throws NoResultException {
        String sql = "select p from Post p";
        List<Post> result = em.createQuery(sql, Post.class).getResultList();
        return result;
    }
}
