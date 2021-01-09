package com.study.message;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class MessageService {
    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Message save(String text) {
        return repository.saveMessage(new Message(text));
    }

//    @Transactional(readOnly = true)
//    public List<Message> getMessages() {
//        return repository.getMessages();
//    }
}
