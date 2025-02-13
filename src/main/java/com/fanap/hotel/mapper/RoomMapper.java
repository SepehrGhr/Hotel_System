package com.fanap.hotel.mapper;

import com.fanap.hotel.dto.room.CreateRoomRequestDTO;
import com.fanap.hotel.dto.room.RoomInfoDTO;
import com.fanap.hotel.model.Room;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    RoomInfoDTO toDTO(Room room);
    Room toEntity(RoomInfoDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRoomFromDto(CreateRoomRequestDTO dto, @MappingTarget Room room);
}