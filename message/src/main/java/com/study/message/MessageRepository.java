package com.study.message;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class MessageRepository {

//   private SessionFactory sessionFactory;
//
//    public MessageRepository(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
    private final static Log log = LogFactory.getLog(MessageRepository.class);

    public Message saveMessage(Message message) {
//        Session session = sessionFactory.openSession();
//        session.save(message);
        return message;
    }
}
