package com.study.message;

import lombok.Getter;

@Getter
public class Message {
    private String text;

    public Message(String text) {
        this.text = text;
    }
}
