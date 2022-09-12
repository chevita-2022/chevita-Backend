package kbsc.kbsc.domain.chat.domain;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ChatMessage {
    //MessageType = ENTER 처음 채팅방에 들어오는 상태
    //MessageType = TALK 이미 session 에 연결되어있고 채팅중인 상태
    public enum MessageType {
        ENTER, TALK
    }
    //@JsonIgnore
    private String messageId;
    //@JsonIgnore
    private Timestamp createdAt;
    private MessageType type;
    private String roomId;
    private Integer sender;
    private String message;
}