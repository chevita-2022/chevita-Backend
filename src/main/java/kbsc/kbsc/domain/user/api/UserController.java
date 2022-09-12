package kbsc.kbsc.domain.user.api;

import kbsc.kbsc.domain.user.dao.impl.UserDAOImpl;
import kbsc.kbsc.domain.user.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//TODO: 데이터베이스 연결확인을 위한 임시 API 이므로 Service 클래스의 코드 작성 정리와 함께 api 수정해야함
@RestController
public class UserController {

    @Autowired
    UserDAOImpl userDAO;
    /*
     @GetMapping("/room/{roomIdx}")
    public List<ChatMessage> findRoomMessages(@PathVariable String roomIdx) {
        return chatService.findRoomMessages(roomIdx);
    }
    */

    @GetMapping("/users/{userid}")
    public Users findUserByIdx(@PathVariable int userid) {
        return userDAO.findUserByIdx(userid);
    }
}