package kbsc.kbsc.domain.chat.application;

import kbsc.kbsc.domain.chat.Repository.ChatRoomRepository;
import kbsc.kbsc.domain.chat.domain.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomRepository getInstance() {
        return chatRoomRepository;
    }

    public ChatRoom findById(Integer chatRoomIdx) {
        return chatRoomRepository.findById(chatRoomIdx)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 채팅방입니다"));
    }

    public List<ChatRoom> findAll() {
        return new ArrayList<>(chatRoomRepository.findAll());
    }
    @Transactional
    public Integer save(ChatRoom chatRoom) {
        return chatRoomRepository.save(chatRoom).getChatRoomIdx();
    }

    @Transactional
    public Integer update(String lastMessage, Integer chatRoomIdx) {
        ChatRoom chatRoom = findById(chatRoomIdx);
        chatRoom.update(lastMessage);
        return chatRoomIdx;
    }





}
