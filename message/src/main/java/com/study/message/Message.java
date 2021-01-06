package com.study.message;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@Getter
@EqualsAndHashCode
public class Message {

    private Integer id;
    private String text;
    private Date createdDate;

    public Message(String text) {
        this.text = text;
        this.createdDate = new Date();
    }

    public Message(int id, String text, Date createdDate) {
        this.text = text;
        this.createdDate = createdDate;
    }
}
