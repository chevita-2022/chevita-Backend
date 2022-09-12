/*
package kbsc.kbsc.domain.chat.application;

import kbsc.kbsc.domain.chat.Repository.ChatMessageRepository;
import kbsc.kbsc.domain.chat.domain.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ChatMessageServiece {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageRepository getInstance() {
        return chatMessageRepository;
    }

    @Transactional
    public List<ChatMessage> findBychatRoomIdx(Integer chatRoomIdx) {

        List<ChatMessage> msgs = new ArrayList<>();
        for (ChatMessage chatMessage: chatMessageRepository.findAll())
        {
            if(chatMessage.getChatRoomIdx() == chatRoomIdx)
                msgs.add(chatMessage);
        }
        msgs.sort();

    }

    class msg implements Comparable<ChatMessage> {


        @Override
        public int compareTo(ChatMessage o) {
            return 0;
        }
    }
}


*/
