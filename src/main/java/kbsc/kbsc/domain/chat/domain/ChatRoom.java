
package kbsc.kbsc.domain.chat.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import kbsc.kbsc.domain.chat.application.ChatService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketSession;

import java.util.*;

@Slf4j
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Getter
@Setter
public class ChatRoom {
    private String roomId;

    //private Integer postIdx;
    private String lastMessage;
    private Integer chaenumi;
    private Integer nanumi;

    @JsonIgnore
    private Set<WebSocketSession> sessions = new HashSet<>();

    private List<ChatMessage> chatMessages = new ArrayList<>();

    @Builder
    public ChatRoom(String roomId, Integer chaenumi, Integer nanumi) {
        this.roomId = roomId;
        this.chaenumi = chaenumi;
        this.nanumi = nanumi;
        //this.postIdx = postIdx;
    }

    public void handlerActions(WebSocketSession session, ChatMessage chatMessage, ChatService chatService) {
        if(!sessions.contains(session)) {
            sessions.add(session);
            //TODO: 나눔 시간대 띄우면서 자동채팅으로 변경하기
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
        }
        sendMessage(chatMessage, chatService, session);

    }
    private <T> void sendMessage(T message, ChatService chatService, WebSocketSession senderSession) {
        sessions.parallelStream()
                .forEach(session -> chatService.sendMessage(session, message, senderSession));
    }
}