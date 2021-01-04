package com.study.message;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.study.message")
public class AppConfig {

    @Bean
    public MessageRepository messageRepository() {
        return new MessageRepository();
    }

    @Bean
    public MessageService messageService() {
        return new MessageService(messageRepository());
    }
}
