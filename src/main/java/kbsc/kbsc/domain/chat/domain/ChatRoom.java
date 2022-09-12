package kbsc.kbsc.domain.chat.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import kbsc.kbsc.domain.chat.application.ChatService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketSession;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.*;
//데이터 베이스 테이블과 1:1 맵핑되도록 구성

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ChatRoom")
public class ChatRoom {

    //pk
    @Id
    Integer chatRoomIdx;

    Integer postIdx;
    Integer nanumiIdx;
    String lastMessage;
    Timestamp updatedAt;
    Integer chaenumiIdx;
    Timestamp createdAt;

    public void update(String msg) {
        this.lastMessage = msg;
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
    /*
    Set<WebSocketSession> sessions = new HashSet<>();
    List<ChatMessage> chatMessages = new ArrayList<>();

    @Builder
    public ChatRoom(String roomId, Integer chaenumi, Integer nanumi) {
        this.roomId = roomId;
        this.chaenumi = chaenumi;
        this.nanumi = nanumi;
        //this.postIdx = postIdx;
    }

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
    }*/
}

