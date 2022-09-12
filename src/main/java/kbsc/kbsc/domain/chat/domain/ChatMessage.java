package kbsc.kbsc.domain.chat.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

//데이터 베이스 테이블과 1:1 맵핑되도록 구성
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ChatMessage")
public class ChatMessage {
    //MessageType = ENTER 처음 채팅방에 들어오는 상태
    //MessageType = TALK 이미 session 에 연결되어있고 채팅중인 상태

    /*public enum MessageType {
        ENTER, TALK
    }*/

    //@JsonIgnore
    @Id
    String messageIdx;

    Integer chatRoomIdx;
    //@JsonIgnore
    Timestamp createdAt;
    Timestamp updatedAt;
    //MessageType type;
    String contents;
    Integer receiverIdx;
}
