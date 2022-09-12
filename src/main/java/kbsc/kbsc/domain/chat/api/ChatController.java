/*
package kbsc.kbsc.domain.chat.api;
import kbsc.kbsc.domain.chat.application.ChatService;
import kbsc.kbsc.domain.chat.domain.ChatMessage;
import kbsc.kbsc.domain.chat.domain.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/{userId}/{otherId}")
    public ChatRoom createRoom(@PathVariable("userId") Integer userId, @PathVariable("otherId") Integer otherId) {

        log.info("chatService={}", chatService.toString());
        //일단 이렇게 받기로는 했는데 방을 만드는거 자체를 채누미 쪽에서 요청하는거라서
        //userId == chaenumi, otherId == nanumi로 봐도 될듯
        return chatService.createRoom(otherId, userId);
    }
    //TODO: No Searializable 오류 -> JsonAutoDetect annotation 설정으로 해결 못했음
    @GetMapping("/{userId}")
    public List<ChatRoom> findAllRoom(@PathVariable("userId") Integer userId) {
        return chatService.findAllRoom(userId);
    }
    @GetMapping("/room/{roomIdx}")
    public List<ChatMessage> findRoomMessages(@PathVariable String roomIdx) {
        return chatService.findRoomMessages(roomIdx);
    }
}*/
