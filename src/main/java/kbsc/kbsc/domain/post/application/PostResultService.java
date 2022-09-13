package kbsc.kbsc.domain.post.application;

import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.post.domain.PostResult;
import kbsc.kbsc.domain.postimage.dao.impl.PostImageDAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostResultService {

    final PostImageDAOImpl postImageDAO;

    @Autowired
    public PostResultService(PostImageDAOImpl postImageDAO) {
        this.postImageDAO = postImageDAO;
    }

    public PostResult findPostResult(Post post)
    {
        System.out.println("findPostResult");
        PostResult postResult = new PostResult(post);
        postResult.setImgUrls(postImageDAO.findByPostIdx(post.getPostIdx()));
        //여기서부터 빈리스트임
        log.info("imgurls={}", postResult.getImgUrls());
        return postResult;
    }
}
