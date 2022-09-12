/*
package kbsc.kbsc.domain.chat.application;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kbsc.kbsc.domain.chat.Repository.ChatRoomRepository;
import kbsc.kbsc.domain.chat.domain.ChatMessage;
import kbsc.kbsc.domain.chat.domain.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ChatService {
    //private final ObjectMapper objectMapper;
    //private Map<String, ChatRoom> chatRooms;

    //private final ChatRoomRepository chatRoomRepository;


    */
/*@PostConstruct
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }*//*


    */
/*public List<ChatRoom> findAllRoom(Integer userId) {
        List<ChatRoom> findRooms = new ArrayList<>();
        for (ChatRoom chatRoom: chatRooms.values()) {
            if(chatRoom.getChaenumi().equals(userId) || chatRoom.getNanumi().equals(userId)) {
                log.info("find!! userId = {}", userId);
                findRooms.add(chatRoom);
                log.info("{} add success", userId);
            }
            else log.info("userId={}", userId);
        }
        return new ArrayList<>(findRooms);
    }
*//*

    */
/*public List<ChatMessage> findRoomMessages(String roomId) {
        ChatRoom chatRoom = chatRooms.get(roomId);
        return  new ArrayList<>(chatRoom.getChatMessages());
    }

    public ChatRoom findRoomById(String roomId) {
        return chatRooms.get(roomId);
    }



    public <T> void sendMessage(WebSocketSession session, T message) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));

        }
        catch (IOException e) {
            log.error(e.getMessage(), e);
        }

    }*//*

}

*/
