package kbsc.kbsc.domain.chat.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketSession;

import javax.persistence.*;
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
    //TODO: @GeneratedValue 적용하기
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GENERATOR")
    @Id
    Long chatRoomIdx;

    Long postIdx;
    Long nanumiIdx;
    String lastMessage;
    Timestamp updatedAt;
    Long chaenumiIdx;
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
    }*/
}

