package com.study.message;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
@Getter
@EqualsAndHashCode
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false, length = 128)
    private String text;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
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
