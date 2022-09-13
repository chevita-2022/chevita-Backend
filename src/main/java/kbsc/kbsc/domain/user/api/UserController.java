package kbsc.kbsc.domain.user.api;

import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.user.dao.impl.UserDAOImpl;
import kbsc.kbsc.domain.user.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

//TODO: 데이터베이스 연결확인을 위한 임시 API 이므로 Service 클래스의 코드 작성 정리와 함께 api 수정해야함
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

    @PostMapping
    public Users saveUser(@RequestBody Users user) throws IOException {
        return userDAO.saveUser(user);
    }

    @GetMapping("/{userid}")
    public Users findUserByIdx(@PathVariable Long userid) {
        return userDAO.findUserByIdx(userid);
    }

    @PatchMapping("/{userid}")
    public Optional<Users> updateInfo(@PathVariable Long userid, @RequestBody Users user) {
        return userDAO.updateInfo(userid, user);
    }

    /*@GetMapping("/{userid}/nanum-history")
    public List<Post> findNanumHistory(@PathVariable Long userid) {
        return userDAO.findNanumHistory(userid);
    }*/
}