package com.fanap.hotel.service;

import com.fanap.hotel.dto.room.CreateRoomRequestDTO;
import com.fanap.hotel.dto.room.RoomInfoDTO;
import com.fanap.hotel.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {

    RoomInfoDTO getRoomDTO(Room room);

    Room createRoomFromDTO(RoomInfoDTO dto);

    List<RoomInfoDTO> getAllRoomsInfo();

    RoomInfoDTO getRoomInfo(Long roomId);

    RoomInfoDTO createRoom(CreateRoomRequestDTO createRoomRequestDTO);

    RoomInfoDTO updateRoom(Long roomId, CreateRoomRequestDTO createRoomRequestDTO);

    void deleteRoom(Long roomId);

    Room getById(Long roomId);
}
