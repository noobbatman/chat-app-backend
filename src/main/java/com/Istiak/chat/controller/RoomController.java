package com.Istiak.chat.controller;

import com.Istiak.chat.dto.CreateRoomRequestDto;
import com.Istiak.chat.entities.Message;
import com.Istiak.chat.entities.Room;
import com.Istiak.chat.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor // Use this for clean dependency injection
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody CreateRoomRequestDto createRoomRequestDto) {
        Room savedRoom = roomService.createRoom(createRoomRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<Room> joinRoom(@PathVariable String roomId) {
        return ResponseEntity.ok(roomService.getRoomById(roomId));
    }
    @GetMapping("/{roomId}/messages")
    public ResponseEntity<Page<Message>> getMessages(@PathVariable String roomId, Pageable pageable) {
        return ResponseEntity.ok(roomService.getMessagesForRoom(roomId, pageable));
    }
}