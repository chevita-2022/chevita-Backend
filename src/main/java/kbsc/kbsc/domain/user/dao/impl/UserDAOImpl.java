package kbsc.kbsc.domain.user.dao.impl;

import kbsc.kbsc.domain.post.application.PostResultService;
import kbsc.kbsc.domain.post.dao.PostJpaRepository;
import kbsc.kbsc.domain.post.dao.PostRespository;
import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.post.domain.PostResult;
import kbsc.kbsc.domain.postimage.application.PostImageService;
import kbsc.kbsc.domain.postimage.dao.impl.PostImageDAOImpl;
import kbsc.kbsc.domain.reservation.dao.ReservationJpaRepository;
import kbsc.kbsc.domain.reservation.domain.Reservation;
import kbsc.kbsc.domain.s3.S3Service;
import kbsc.kbsc.domain.user.Repository.UserRepository;
import kbsc.kbsc.domain.user.dao.UserDAO;
import kbsc.kbsc.domain.user.domain.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserDAOImpl implements UserDAO {

    final UserRepository userRepository;
    final S3Service s3Service;

    final PostResultService postResultService;
    final ReservationJpaRepository reservationJpaRepository;
    final PostJpaRepository postJpaRepository;

    //의존성 주입, 싱글톤 빈으로 미리 올려둠
    @Autowired
    public UserDAOImpl(UserRepository userRepository, S3Service s3Service,
                       ReservationJpaRepository reservationJpaRepository,
                       PostJpaRepository postJpaRepository,
                       PostResultService postResultService) {
        this.s3Service = s3Service;
        this.userRepository = userRepository;
        this.reservationJpaRepository = reservationJpaRepository;
        this.postJpaRepository = postJpaRepository;
        this.postResultService = postResultService;
    }

    @Override
    public Users saveUser(Users userEntity) throws IOException {
        String imgUrl = s3Service.download(userEntity.getProfileImgUrl());
        userEntity.setProfileImgUrl(imgUrl);
        userEntity.setVital(67L);
        log.info("imgUrl={}", imgUrl);
        Users user =userRepository.save(userEntity);
        log.info("user userIdx = {}", user.getUserIdx());
        userEntity.setUserIdx(user.getUserIdx());

        //저장된 값 확인하기
        Optional<Users> findedUser = userRepository.findById(user.getUserIdx());
        findedUser.ifPresent(selectedUser ->
        {
            log.info("saved userIdx = {}", selectedUser.getUserIdx());
            log.info("saved userVital = {}", selectedUser.getVital());

        });
        return user;
    }

    //나눔기록 조회 예약 테이블 조회 -> 나눔완료된 postIdx 중 작성자 Idx == userId
    public List<PostResult> findNanumHistory(Long userId) {
        List<PostResult> postResults = new ArrayList<>();
        List<Reservation> reservations = reservationJpaRepository.findAll();
        for (Reservation reservation: reservations) {
            if(reservation.getNanumStatus() == "나눔완료" && reservation.getNanumiIdx() == userId)
            {
                log.info("nanum completed={}", reservation);
                Optional<Post> post = postJpaRepository.findById(reservation.getPostIdx());
                post.ifPresent(selectedPost -> {
                    PostResult postResult = postResultService.findPostResult(selectedPost);
                    postResults.add(postResult);
                });

            }


        }
        return postResults;
    }

    public List<PostResult> findChaenumiHistory(Long userId) {
        List<PostResult> postResults = new ArrayList<>();
        List<Reservation> reservations = reservationJpaRepository.findAll();
        for (Reservation reservation: reservations) {
            if(reservation.getNanumStatus() == "나눔완료" && reservation.getTakerIdx() == userId)
            {
                log.info("nanum completed={}", reservation);
                Optional<Post> post = postJpaRepository.findById(reservation.getPostIdx());
                post.ifPresent(selectedPost -> {
                    PostResult postResult = postResultService.findPostResult(selectedPost);
                    postResults.add(postResult);
                });

            }


        }
        return postResults;
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

            userRepository.save(selectUser);
        });

        return userRepository.findById(targetIdx);

    }


}