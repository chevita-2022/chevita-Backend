package kbsc.kbsc.domain.post.application;

import kbsc.kbsc.domain.hashtag.dao.HashtagDaoImpl;
import kbsc.kbsc.domain.hashtag.domain.Hashtag;
import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.post.domain.PostResult;
import kbsc.kbsc.domain.postimage.Repository.PostImageRepository;
import kbsc.kbsc.domain.postimage.dao.impl.PostImageDAOImpl;
import kbsc.kbsc.domain.postimage.domain.PostImage;
import kbsc.kbsc.domain.sharingtimezone.dao.impl.SharingTimeZoneDaoImpl;
import kbsc.kbsc.domain.sharingtimezone.domain.SharingTimeZone;
import kbsc.kbsc.domain.sharingtimezone.repository.SharingTimeZoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PostResultService {

    final PostImageDAOImpl postImageDAO;
    final SharingTimeZoneDaoImpl sharingTimeZoneDaoImpl;
    final PostImageRepository postImageRepository;
    final SharingTimeZoneRepository sharingTimeZoneRepository;
    final HashtagDaoImpl hashtagDaoImpl;



    @Autowired
    public PostResultService(PostImageDAOImpl postImageDAO,
                             SharingTimeZoneDaoImpl sharingTimeZoneDaoImpl,
                             PostImageRepository postImageRepository,
                             SharingTimeZoneRepository sharingTimeZoneRepository,
                             HashtagDaoImpl hashtagDaoImpl) {
        this.postImageDAO = postImageDAO;
        this.sharingTimeZoneDaoImpl = sharingTimeZoneDaoImpl;
        this.postImageRepository = postImageRepository;
        this.sharingTimeZoneRepository = sharingTimeZoneRepository;
        this.hashtagDaoImpl = hashtagDaoImpl;
    }

    public PostResult saveImg(PostResult postResult) throws IOException {
        Long postIdx = postResult.getPostIdx();
        log.info("postIdx={}", postIdx);//여기 null 찍힘
        List<String> urls = postResult.getImgUrls();
        List<String> results = new ArrayList<>();

        for(String url : urls) {
            PostImage postImage = PostImage.builder().
                    postIdx(postIdx).
                    imgUrl(url).
                    build();
            postImageDAO.saveImgUrl(postImage);
            results.add(postImage.getImgUrl());
        }
        postResult.setImgUrls(results);
        return postResult;
    }

    public PostResult saveHashtag(PostResult postResult) throws IOException{
        Long postIdx = postResult.getPostIdx(); //해시태그 테이블의 postidx 칼럼에 저장할거임

        List<String> hashtagList = postResult.getHashtags(); //해시태그 넣은 배열
        List<String> results = new ArrayList<>();

        for(String tag: hashtagList){
            Hashtag hashtag = Hashtag.builder()
                    .postIdx(postIdx)
                    .tagName(tag)
                    .build();
            hashtagDaoImpl.saveHashtag(hashtag);
            results.add(hashtag.getTagName());
        }
        postResult.setHashtags(results);
        return postResult;
    }

    public PostResult saveSharingTimeZone(PostResult postResult) throws IOException{ //이미지까지 저장된 result를 받아옴
            Long postIdx = postResult.getPostIdx(); //post id 찾기
            log.info("postIdx={}", postIdx);
             List<List<String>> availableTimezone = postResult.getSharingTimeZones(); //List<List<String>> availableDates;
            /*가져온거를  짤라서 디비에 저장할거야
            availableDate = [나눔일자, 나눔시간대] = [availableDate.get(0),
            availableDates = [[나눔일자, 나눔시간대], [나눔일자, 나눔시간대], [나눔일자, 나눔시간대]] = [availableDate.get(0),
            */
            for(List<String> availableDate: availableTimezone){ //[나눔일자, 나눔시간대]
                SharingTimeZone sharingTimeZone = SharingTimeZone.builder()// sharingTimeZone = [나눔일자, 나눔시간대]
                        .postIdx(postIdx)
                        .dateZone(availableDate.get(0)) //나눔일자
                        .timeZone(availableDate.get(1)) //나눔시간대
                        .build();
                sharingTimeZoneDaoImpl.saveSharingTimeZone(sharingTimeZone); // Long sharingTimeZoneIdx; Long postIdx; String dateZone;String timeZone;

            }
            postResult.setSharingTimeZones(availableTimezone);
            log.info("after setting postResult ={}", postResult.getSharingTimeZones());
            return postResult;

    }

    public PostResult findPostResult(Post post)
    {
        PostResult postResult = new PostResult(post);
        postResult.setImgUrls(postImageDAO.findByPostIdx(post.getPostIdx())); //그냥 리스트

        log.info("findPostResult before setting sharingtimezones= {}", postResult);
        
        //나눔시간대 설정
        //postResult.setSharingTimeZones(List<List<String>> sharingTimeZones);
        //post idx로 해당 post의 나눔시간대만 가져오기
        //postResult.sharingtimezone설정(postidx로 shaingTimeZone의 목록중에서 postidx가 일히하는 것을 add한다.
        postResult.setSharingTimeZones(sharingTimeZoneDaoImpl.findByPostIdx(post.getPostIdx()));

        log.info("findPostResult after setting sharingtimezones = {}", postResult);


        return postResult;
    }



}
