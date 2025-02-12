package com.fanap.hotel.mapper;

import com.fanap.hotel.dto.room.RoomInfoDTO;
import com.fanap.hotel.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    RoomInfoDTO toDTO(Room room);
    Room toEntity(RoomInfoDTO dto);
}