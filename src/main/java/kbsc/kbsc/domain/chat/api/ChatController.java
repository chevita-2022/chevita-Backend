package kbsc.kbsc.domain.chat.api;

import kbsc.kbsc.domain.chat.application.ChatMessageService;
import kbsc.kbsc.domain.chat.application.ChatRoomService;
import kbsc.kbsc.domain.chat.domain.ChatMessage;
import kbsc.kbsc.domain.chat.domain.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatRoomService chatRoomService;
    private final ChatMessageService chatMessageService;

    @PostMapping("/{userId}/{otherId}")
    public Long saveRoom(@PathVariable("userId") Long userId, @PathVariable("otherId") Long otherId) {
        //일단 이렇게 받기로는 했는데 방을 만드는거 자체를 채누미 쪽에서 요청하는거라서
        //userId == chaenumi, otherId == nanumi로 봐도 될듯
        return chatRoomService.save(otherId, userId);
    }

    //TODO: No Searializable 오류 -> JsonAutoDetect annotation 설정으로 해결 못했음
    @GetMapping("/{userId}")
    public List<ChatRoom> findAllRoom(@PathVariable("userId") Long userId) {
        return chatRoomService.findAll(userId);
    }

    @GetMapping("/room/{roomIdx}")
    public List<ChatMessage> findRoomMessages(@PathVariable Long roomIdx) {
        return chatMessageService.findBychatRoomIdx(roomIdx);
    }

}
