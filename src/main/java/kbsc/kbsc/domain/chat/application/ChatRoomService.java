package kbsc.kbsc.domain.chat.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import kbsc.kbsc.domain.chat.Repository.ChatRoomRepository;
import kbsc.kbsc.domain.chat.domain.ChatMessage;
import kbsc.kbsc.domain.chat.domain.ChatRoom;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ObjectMapper objectMapper;
    private  static long sequence = 0L;

    /*public ChatRoomRepository getInstance() {
        return chatRoomRepository;
    }*/


    public ChatRoom findById(Long chatRoomIdx) {
        return chatRoomRepository.findById(chatRoomIdx)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 채팅방입니다"));
    }

    public List<ChatRoom> findAll(Long userIdx) {
        List<ChatRoom> allRooms = chatRoomRepository.findAll();
        List<ChatRoom> findRooms = new ArrayList<>();
        for (ChatRoom room:allRooms) {
            if(room.getChaenumiIdx()==userIdx || room.getNanumiIdx() ==userIdx)
                findRooms.add(room);
        }
        return new ArrayList<>(findRooms);
    }
    @Transactional
    public Long save(Long nanumi, Long chaenumi) {
        /*
        * ChatRoom chatRoom = ChatRoom.builder()
                .roomId(roomId)
                .chaenumi(chaenumi)
                .nanumi(nanumi)
                .build();
        *
        * */
        //TODO: LastMessage 가져오기
        //TODO: postIdx 가져오기
        ChatRoom chatRoom = ChatRoom.builder()
                .chatRoomIdx(++sequence)
                .postIdx(100L)
                .nanumiIdx(nanumi)
                .lastMessage("dd")
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .chaenumiIdx(chaenumi)
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .build();

        return chatRoomRepository.save(chatRoom).getChatRoomIdx();
    }

    @Transactional
    public Long update(String lastMessage, Long chatRoomIdx) {
        ChatRoom chatRoom = findById(chatRoomIdx);
        chatRoom.update(lastMessage);
        return chatRoomIdx;
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
    public <T> void sendMessage(WebSocketSession session, T message) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));

        }
        catch (IOException e) {
            log.error(e.getMessage(), e);
        }

    }

    /*public ChatRoom createRoom(Integer nanumi, Integer chaenumi) {
        Long roomId = UUID.randomUUID().toString();
        ChatRoom chatRoom = ChatRoom.builder()
                .roomId(roomId)
                .chaenumi(chaenumi)
                .nanumi(nanumi)
                .build();
        chatRooms.put(roomId, chatRoom);
        return chatRoom;
    }*/





}
