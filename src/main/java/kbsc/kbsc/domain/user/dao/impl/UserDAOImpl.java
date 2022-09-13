package kbsc.kbsc.domain.user.dao.impl;

import kbsc.kbsc.domain.post.dao.PostRespository;
import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.s3.S3Service;
import kbsc.kbsc.domain.user.Repository.UserRepository;
import kbsc.kbsc.domain.user.dao.UserDAO;
import kbsc.kbsc.domain.user.domain.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserDAOImpl implements UserDAO {

    final UserRepository userRepository;
    final S3Service s3Service;

    //의존성 주입, 싱글톤 빈으로 미리 올려둠
    @Autowired
    public UserDAOImpl(UserRepository userRepository, S3Service s3Service) {
        this.s3Service = s3Service;
        this.userRepository = userRepository;
    }

    @Override
    public Users saveUser(Users userEntity) throws IOException {
        String imgUrl = s3Service.download(userEntity.getProfileImgUrl());
        userEntity.setProfileImgUrl(imgUrl);
        log.info("imgUrl={}", imgUrl);
        userRepository.save(userEntity);

        return userEntity;
    }



    @Override
    public Users findUserByIdx(Long userIdx) {

        Users userEntity= userRepository.findById(userIdx).orElseThrow(IllegalArgumentException::new);
        return userEntity;
    }


    //프로필 수정 사용되지 않음
    public Optional<Users> updateInfo(Long targetIdx, Users user) {
        //TODO: Exception 처리하기
        //TODO: 사용자위치 처리하기
        //TODO: S3는 아예 따로 처리를 해줘야하나..? 여기 다시 보기
        Optional<Users> updateUser = userRepository.findById(targetIdx);
        updateUser.ifPresent(selectUser->{
            selectUser.setUserNickName(user.getUserNickName());
            selectUser.setUserAddress(user.getUserAddress());
            selectUser.setProfileImgUrl(user.getProfileImgUrl());
            selectUser.setIntroduction(user.getIntroduction());
            selectUser.setUserhashTag(user.getUserhashTag());

            userRepository.save(selectUser);
        });

        return userRepository.findById(targetIdx);

    }


}