package kbsc.kbsc.domain.user.dao.impl;

import kbsc.kbsc.domain.post.application.PostResultService;
import kbsc.kbsc.domain.post.application.PostService;
import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.post.domain.PostResult;
import kbsc.kbsc.domain.reservation.application.ReservationService;
import kbsc.kbsc.domain.reservation.domain.Reservation;
import kbsc.kbsc.domain.s3.S3Service;
import kbsc.kbsc.domain.user.Repository.UserRepository;
import kbsc.kbsc.domain.user.dao.UserDAO;
import kbsc.kbsc.domain.user.domain.Users;
import kbsc.kbsc.domain.user.dto.SocialUserDto;
import kbsc.kbsc.domain.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserDAOImpl implements UserDAO {

    final UserRepository userRepository;
    final S3Service s3Service;

    final PostResultService postResultService;
    final PostService postService;
    final ReservationService reservationService;

    //의존성 주입, 싱글톤 빈으로 미리 올려둠
    @Autowired
    public UserDAOImpl(UserRepository userRepository, S3Service s3Service,
                       PostResultService postResultService,
                       PostService postService, ReservationService reservationService) {
        this.s3Service = s3Service;
        this.userRepository = userRepository;
        this.postResultService = postResultService;
        this.postService = postService;
        this.reservationService = reservationService;
    }


    public Users fillUserInfo(UserDto userDto) throws IOException {
        //useDto에는 유저 아이디, 유저 닉네임, 유저 주소, 유저 프로필이미지 있음
        Users targetUser = findUserByIdx(userDto.getUserIdx());
        String imgUrl = s3Service.download(userDto.getProfileImgUrl());
        targetUser.setProfileImgUrl(imgUrl);
        targetUser.setVital(67L);
        log.info("imgUrl={}", imgUrl);
        targetUser.setUserAddress(userDto.getUserAddress());
        targetUser.setUserNickName(userDto.getUserNickName());



        //저장된 값 확인하기
        Users saveduser = userRepository.save(targetUser);
        return saveduser;

    }
    public Users findByToken(SocialUserDto socialUserDto) {
        List<Users> users = userRepository.findAll();

        for (Users curUser: users) {
            log.info("curUser.token={}, curUser.userIdx={}", curUser.getToken(), curUser.getUserIdx());
            if(curUser.getToken().equals(socialUserDto.getToken()))
                return curUser;
        }
        return null;
    }
    @Override
    public Users saveUser(Users userEntity) throws IOException {
        return userRepository.save(userEntity);
    }

    public Long joinIn(SocialUserDto socialUserDto) throws IOException {
        Users users = new Users();
        users.setToken(socialUserDto.getToken());
        Users saveUsers = saveUser(users);
        return saveUsers.getUserIdx();

    }

    //나눔기록 조회 예약 테이블 조회 -> 나눔완료된 postIdx 중 작성자 Idx == userId
    public List<PostResult> findNanumHistory(Long userId) {
        List<PostResult> postResults = new ArrayList<>();
        List<Reservation> reservations = reservationService.findAllReservation();

        for (Reservation reservation: reservations) {
            log.info("reservation : {}", reservation.getPostIdx());
            if(reservation.getNanumStatus().equals("나눔완료") && reservation.getNanumiIdx() == userId)
            {
                log.info("nanum completed={}", reservation);
                Post post = postService.getSinglePost(reservation.getPostIdx());
                PostResult postResult = postResultService.findPostResult(post);
                    postResults.add(postResult);

            }


        }
        return postResults;
    }

    public List<PostResult> findChaenumiHistory(Long userId) {
        List<PostResult> postResults = new ArrayList<>();
        List<Reservation> reservations = reservationService.findAllReservation();

        for (Reservation reservation: reservations) {
            log.info("reservation : {}", reservation.getPostIdx());
            if(reservation.getNanumStatus().equals("나눔완료") && reservation.getTakerIdx() == userId)
            {
                log.info("nanum completed={}", reservation);
                Post post = postService.getSinglePost(reservation.getPostIdx());
                PostResult postResult = postResultService.findPostResult(post);
                postResults.add(postResult);

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