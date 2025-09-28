package com.Istiak.chat.controller;

import com.Istiak.chat.entities.Message;
import org.springframework.messaging.handler.annotation.Payload;
import java.time.LocalDateTime;

import com.Istiak.chat.payload.MessageRequest;
import com.Istiak.chat.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
    private final RoomService roomService;

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(
            @DestinationVariable String roomId,
            @Payload  MessageRequest request
    ){

        logger.info("--- MESSAGE RECEIVED ---");
        logger.info("Room ID: {}", roomId);
        logger.info("Payload: {}", request);

        Message message = new Message();
        message.setSender(request.getSender());
        message.setContent(request.getContent());
        message.setAvatar(request.getAvatar());     // 2. SET the avatar
        message.setTimeStamp(LocalDateTime.now());

        roomService.addMessageToRoom(roomId, message);
        return message;
    }
}
