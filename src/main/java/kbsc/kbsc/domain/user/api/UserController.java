package kbsc.kbsc.domain.user.api;

import kbsc.kbsc.domain.user.dao.impl.UserDAOImpl;
import kbsc.kbsc.domain.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//TODO: 데이터베이스 연결확인을 위한 임시 API 이므로 Service 클래스의 코드 작성 정리와 함께 api 수정해야함
@RestController
public class UserController {

    UserDAOImpl userDAO;

    @Autowired
    public UserController(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }



    /*
     @GetMapping("/room/{roomIdx}")
    public List<ChatMessage> findRoomMessages(@PathVariable String roomIdx) {
        return chatService.findRoomMessages(roomIdx);
    }
    */

    @GetMapping("/users/{userid}")
    public User findUserByIdx(@PathVariable int userid) {
        return userDAO.findUserByIdx(userid);
    }
}