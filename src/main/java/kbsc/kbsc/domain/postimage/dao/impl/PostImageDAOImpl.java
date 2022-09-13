package kbsc.kbsc.domain.postimage.dao.impl;

import kbsc.kbsc.domain.postimage.Repository.PostImageRepository;
import kbsc.kbsc.domain.postimage.dao.PostImageDAO;
import kbsc.kbsc.domain.postimage.domain.PostImage;
import kbsc.kbsc.domain.user.dao.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class PostImageDAOImpl implements PostImageDAO {

    final PostImageRepository postImageRepository;

    //의존성 주입, 싱글톤 빈으로 미리 올려둠

    public PostImageDAOImpl(PostImageRepository postImageRepository) {
        this.postImageRepository = postImageRepository;
    }

    @Override
    public List<String> findByPostIdx(Long postIdx) {
        List<String> imgUrls = new ArrayList<>();
        for (PostImage postImg : postImageRepository.findAll()) {
            log.info("postImg={}", postImg);
            log.info("postImg.postIdx={}", postImg.getPostIdx());
            if(postImg.getPostIdx() == postIdx)
            {
                imgUrls.add(postImg.getImgUrl());
                log.info("imgUrls={}", imgUrls);
            }
        }

        return new ArrayList<>(imgUrls);
    }
}
