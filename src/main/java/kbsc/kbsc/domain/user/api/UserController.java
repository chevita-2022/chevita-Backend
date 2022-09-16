package kbsc.kbsc.domain.user.api;

import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.post.domain.PostResult;
import kbsc.kbsc.domain.user.dao.impl.UserDAOImpl;
import kbsc.kbsc.domain.user.domain.Users;
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
    /*
     @GetMapping("/room/{roomIdx}")
    public List<ChatMessage> findRoomMessages(@PathVariable String roomIdx) {
        return chatService.findRoomMessages(roomIdx);
    }
    */

    @GetMapping("/tmp/{userid}")
    public Users getTmp(@PathVariable Long userid)
    {
        Users user = findUserByIdx(userid);
        log.info("useridx = {}", user.getUserIdx());
        log.info("usernickname = {}", user.getUserNickName());
        log.info("useraddress = {}", user.getUserAddress());
        log.info("useraddress = {}", user.getProfileImgUrl());
        return user;
    }
    @PostMapping("/login")
    public Long saveSocialLogin(@RequestBody Users user) throws IOException {
        Long userIdx = 0L;
        if(userDAO.isMember(user)) // 이미 멤버임
            return userDAO.findByToken(user).getUserIdx();
        else userIdx = userDAO.saveUser(user).getUserIdx();
        return userIdx;
    }

    @PostMapping
    public Users saveUser(@RequestBody UserDto userDto) throws IOException {
        return userDAO.fillUserInfo(userDto);
    }

    @GetMapping("/{userid}")
    public Users findUserByIdx(@PathVariable Long userid) {
        return userDAO.findUserByIdx(userid);
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