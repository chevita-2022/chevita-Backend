package kbsc.kbsc.domain.chat.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import kbsc.kbsc.domain.chat.domain.ChatMessage;
import kbsc.kbsc.domain.chat.domain.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.sql.Timestamp;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class MyWebSocketHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("{}", payload);
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);

        //TODO: handleTextMessage 에 관련되지 않은 코드들이 너무 많음 -> 코드 리팩토링


        ChatRoom chatRoom = chatService.findRoomById(chatMessage.getRoomId());

        //TODO:구조상 ChatMessage 객체에 접근하는 코드들의 위치를 리팩토링해야함
        chatRoom.getChatMessages().add(chatMessage);
        for (ChatMessage msg: chatRoom.getChatMessages()
        ) {
            log.info("saved msg={}", msg);

        }
        chatRoom.setLastMessage(chatMessage.getMessage());


 log.info("message={}", chatMessage.getRoomId());
        log.info("message={}", chatMessage.getMessageId());
        log.info("message={}", chatMessage.getMessage());
        log.info("message={}", chatMessage.getSender());
        log.info("message={}", chatMessage.getCreatedAt());
        log.info("lastMessage={}", chatRoom.getLastMessage());



        chatRoom.handlerActions(session, chatMessage, chatService);

    }


}
