package kbsc.kbsc.domain.hashtag.dao;

import kbsc.kbsc.domain.hashtag.domain.Hashtag;
import kbsc.kbsc.domain.hashtag.repository.HashtagRespository;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component //타입기반의 자동주입 어노테이션
public class HashtagDaoImpl {
    final HashtagRespository hashtagRepository;

    public HashtagDaoImpl(HashtagRespository hashtagRespository) {
        this.hashtagRepository = hashtagRespository;
    }


    public String saveHashtag(Hashtag hashtag) throws IOException {
        hashtag.setTagName(hashtag.getTagName()); //이건 왜하는거지
        hashtagRepository.save(hashtag);
        return hashtag.getTagName();

    }
}
