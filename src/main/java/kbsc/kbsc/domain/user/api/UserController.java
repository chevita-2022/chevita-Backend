package kbsc.kbsc.domain.user.api;

import kbsc.kbsc.domain.login.dto.UserCheckDto;
import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.post.domain.PostResult;
import kbsc.kbsc.domain.reviews.application.ReviewService;
import kbsc.kbsc.domain.reviews.dto.ReviewDTO;
import kbsc.kbsc.domain.user.dao.impl.UserDAOImpl;
import kbsc.kbsc.domain.user.domain.Users;
import kbsc.kbsc.domain.user.dto.SocialUserDto;
import kbsc.kbsc.domain.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDAOImpl userDAO;
    @Autowired
    ReviewService reviewService;

    @PostMapping("/login")
    public UserCheckDto login(@RequestBody SocialUserDto socialUserDto) throws IOException {
        UserCheckDto userCheckDto = new UserCheckDto();
        Users findUser = userDAO.findByToken(socialUserDto);
        if(findUser != null) {
            log.info("findUser.getUserIdx={}", findUser.getUserIdx());
            userCheckDto.setUserIdx(findUser.getUserIdx());
            userCheckDto.setExistingUser(true);
            return userCheckDto;
        }
        else {
            Long userIdx = userDAO.joinIn(socialUserDto);
            userCheckDto.setUserIdx(userIdx);
            userCheckDto.setExistingUser(false);
            return userCheckDto;
        }
    }

    @PostMapping
    public Users saveUser(@RequestBody UserDto userDto) throws IOException {
        return userDAO.fillUserInfo(userDto);
    }

    @GetMapping("/{userid}")
    public Users findUserByIdx(@PathVariable Long userid) {
        Users user = userDAO.findUserByIdx(userid);
        List<ReviewDTO> reviewDTOs = reviewService.getReviewList(userid);
        double totalSum = 0;
        Long size = Long.valueOf(reviewDTOs.size());
        for (ReviewDTO reviewDto: reviewDTOs) {
            totalSum += reviewDto.getVital();
        }
        user.setVital(Long.valueOf((int)totalSum/size));
        return user;
    }

    @PatchMapping("/{userid}")
    public Optional<Users> updateInfo(@PathVariable Long userid, @RequestBody Users user) {
        return userDAO.updateInfo(userid, user);
    }

    //나눔기록 조회 예약 테이블 조회 -> 나눔완료된 postIdx 중 작성자 Idx == userId
    @GetMapping("/{userid}/nanum-history")
    public List<PostResult> findNanumHistory(@PathVariable Long userid) {
        return userDAO.findNanumHistory(userid);
    }

    @GetMapping("/{userid}/chaenum-history")
    public List<PostResult> findChaenumHistory(@PathVariable Long userid) {
        return userDAO.findChaenumiHistory(userid);
    }
}
