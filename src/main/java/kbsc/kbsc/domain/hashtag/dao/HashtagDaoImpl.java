package kbsc.kbsc.domain.hashtag.dao;

import kbsc.kbsc.domain.hashtag.domain.Hashtag;
import kbsc.kbsc.domain.hashtag.repository.HashtagRespository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component //타입기반의 자동주입 어노테이션
public class HashtagDaoImpl {
    final HashtagRespository hashtagRepository;

    public HashtagDaoImpl(HashtagRespository hashtagRespository) {
        this.hashtagRepository = hashtagRespository;
    }


    public void saveHashtag(Hashtag hashtag) throws IOException {
        hashtag.setPostIdx(hashtag.getPostIdx());
        hashtag.setTagName(hashtag.getTagName());//해시태그 저장
        hashtagRepository.save(hashtag); //jpa 사용해서 ㅓ장

    }

    public List<String> findByPostIdx(Long postIdx) {
        List<String> hashtags = new ArrayList<>();

        for (Hashtag hashtag: hashtagRepository.findAll()){
            if(hashtag.getPostIdx() == postIdx){
                hashtags.add(hashtag.getTagName());
            }
        }
        return hashtags;
    }
}
