package com.Istiak.chat.service.impl;

import com.Istiak.chat.dto.CreateRoomRequestDto;
import com.Istiak.chat.entities.Message;
import com.Istiak.chat.entities.Room;
import com.Istiak.chat.repositories.RoomRepository;
import com.Istiak.chat.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public Room createRoom(CreateRoomRequestDto createRoomRequestDto){
        String roomId=createRoomRequestDto.getRoomId();
        if(roomRepository.findByRoomId(roomId)!=null){
            throw new IllegalArgumentException("Room with ID '" + roomId + "' already exists.");
        }
        Room room = new Room();
        room.setRoomId(roomId);
        return roomRepository.save(room);
    }
    @Override
    public Room getRoomById(String roomId){
        Room room=roomRepository.findByRoomId(roomId);
        if(room==null){
            throw new IllegalArgumentException("Room with ID '" + roomId + "' not found.");
        }
        return room;
    }
    @Override
    public void addMessageToRoom(String roomId, Message message){
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            room = new Room();
            room.setRoomId(roomId);
        }
        message.setTimeStamp(LocalDateTime.now());
        room.getMessages().add(message);
        roomRepository.save(room);
    }

    @Override
    public Page<Message> getMessagesForRoom(String roomId,Pageable pageable){
        Room room = getRoomById(roomId);
        List<Message> messages = room.getMessages();
        Collections.reverse(messages);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), messages.size());
        if (start > messages.size()) {
            return new PageImpl<>(Collections.emptyList(), pageable, messages.size());
        }
        List<Message> paginatedMessages = messages.subList(start, end);
        return new PageImpl<>(paginatedMessages, pageable, messages.size());
    }

}
