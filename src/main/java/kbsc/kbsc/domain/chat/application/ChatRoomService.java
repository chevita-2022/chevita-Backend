/*
package kbsc.kbsc.domain.chat.application;

import kbsc.kbsc.domain.chat.Repository.ChatRoomRepository;
import kbsc.kbsc.domain.chat.domain.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomRepository getInstance() {
        return chatRoomRepository;
    }

    public ChatRoom findById(Integer chatRoomIdx) {
        return chatRoomRepository.findById(chatRoomIdx)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 채팅방입니다"));
    }

    public List<ChatRoom> findAll() {
        return new ArrayList<>(chatRoomRepository.findAll());
    }
    @Transactional
    public Integer save(ChatRoom chatRoom) {
        return chatRoomRepository.save(chatRoom).getChatRoomIdx();
    }

    @Transactional
    public Integer update(String lastMessage, Integer chatRoomIdx) {
        ChatRoom chatRoom = findById(chatRoomIdx);
        chatRoom.update(lastMessage);
        return chatRoomIdx;
    }





}
*/
package kbsc.kbsc.domain.chat.application;

import kbsc.kbsc.domain.chat.domain.ChatMessage;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class ChatRoomService {

    private final Set<WebSocketSession> sessions = new HashSet<>();
    private final List<ChatMessage> chatMessages = new ArrayList<>();



    public void handlerActions(WebSocketSession session, ChatMessage chatMessage, ChatService chatService) {
        if(chatMessage.getType().equals(ChatMessage.MessageType.ENTER)) {
            sessions.add(session);
            //TODO: 나눔 시간대 띄우면서 자동채팅으로 변경하기
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
        }
        sendMessage(chatMessage, chatService);
    }
    private <T> void sendMessage(T message, ChatService chatService) {
        sessions.parallelStream()
                .forEach(session -> chatService.sendMessage(session, message));
    }
}