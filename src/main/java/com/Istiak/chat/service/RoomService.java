package com.Istiak.chat.service;

import com.Istiak.chat.dto.CreateRoomRequestDto;
import com.Istiak.chat.entities.Message;
import com.Istiak.chat.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface RoomService {
    Room createRoom(CreateRoomRequestDto createRoomRequestDto);
    Room getRoomById(String roomId);
    Page<Message> getMessagesForRoom(String roomId, Pageable pageable);
    void addMessageToRoom(String roomId, Message message);

}
