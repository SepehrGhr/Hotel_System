package com.fanap.hotel.service;

import com.fanap.hotel.dto.room.CreateRoomRequestDTO;
import com.fanap.hotel.dto.room.RoomInfoDTO;
import com.fanap.hotel.exception.RoomNotFoundException;
import com.fanap.hotel.mapper.RoomMapper;
import com.fanap.hotel.model.Room;
import com.fanap.hotel.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomInfoDTO getRoomDTO(Room room) {
        return RoomMapper.INSTANCE.toDTO(room);
    }

    public Room createRoomFromDTO(RoomInfoDTO dto) {
        return RoomMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public List<RoomInfoDTO> getAllRoomsInfo() {
        return roomRepository.findAll().stream().map(this::getRoomDTO).toList();
    }

    @Override
    public RoomInfoDTO getRoomInfo(Long roomId) {
        return getRoomDTO(getById(roomId));
    }

    @Override
    public RoomInfoDTO createRoom(CreateRoomRequestDTO createRoomRequestDTO) {
        Room room = roomRepository.save(createRoomRequestDTO.toEntity());
        return getRoomDTO(room);
    }

    @Override
    public RoomInfoDTO updateRoom(Long roomId, CreateRoomRequestDTO createRoomRequestDTO) {
        Room room = getById(roomId);
        RoomMapper.INSTANCE.updateRoomFromDto(createRoomRequestDTO, room);
        roomRepository.save(room);
        return getRoomDTO(room);
    }

    @Override
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    private Room getById(Long roomId){
        return roomRepository.findById(roomId).orElseThrow(() -> new RoomNotFoundException(roomId));
    }
}
