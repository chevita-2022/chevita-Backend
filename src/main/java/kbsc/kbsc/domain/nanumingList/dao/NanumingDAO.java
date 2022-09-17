package kbsc.kbsc.domain.nanumingList.dao;

import kbsc.kbsc.domain.post.application.PostService;
import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.reservation.application.ReservationService;
import kbsc.kbsc.domain.user.Repository.UserRepository;
import kbsc.kbsc.domain.user.domain.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class NanumingDAO {

    private final UserRepository userRepository;
    private final ReservationService reservationService;
    private final PostService postService;

    public NanumingDAO(UserRepository userRepository,
                       ReservationService reservationService, PostService postService) {
        this.userRepository = userRepository;
        this.reservationService = reservationService;
        this.postService = postService;
    }

    public String getUserNickName(Long userIdx) throws Exception {
        AtomicReference<String> nickname = null;
        Users user = userRepository.findById(userIdx).orElseThrow(Exception::new);
        return user.getUserNickName();
    }

    public String getUserProfileUrl(Long userIdx) throws Exception {
        AtomicReference<String> nickname = null;
        Users user = userRepository.findById(userIdx).orElseThrow(Exception::new);
        return user.getProfileImgUrl();
    }


}
