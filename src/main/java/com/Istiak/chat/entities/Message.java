package com.Istiak.chat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {
    private String sender;
    private String content;
    private LocalDateTime timeStamp;
    private String avatar;

    public Message(String sender, String content,String avatar) {
        this.sender = sender;
        this.content = content;
        this.timeStamp=LocalDateTime.now();
        this.avatar=avatar;
    }
}
