package kbsc.kbsc.domain.chat.domain;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ChatMessage")
public class ChatMessage {
    //MessageType = ENTER 처음 채팅방에 들어오는 상태
    //MessageType = TALK 이미 session 에 연결되어있고 채팅중인 상태

    @Id
    Long messageIdx;

    Long chatRoomIdx;
    Timestamp createdAt;
    Timestamp updatedAt;
    Long receiverIdx;
    String contents;
    int read;

}