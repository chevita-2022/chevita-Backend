package kbsc.kbsc.domain.chat.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ChatMessage {
    //MessageType = ENTER 처음 채팅방에 들어오는 상태
    //MessageType = TALK 이미 session 에 연결되어있고 채팅중인 상태

    //@JsonIgnore
    private String messageId;

    //@JsonIgnore
    private LocalDateTime createdAt;

    private String roomId;
    private Integer sender;
    private String message;
}