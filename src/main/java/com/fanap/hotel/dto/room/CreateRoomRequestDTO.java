package com.fanap.hotel.dto.room;

import com.fanap.hotel.model.Room;
import com.fanap.hotel.model.RoomType;
import com.fanap.hotel.model.Status;

import java.math.BigDecimal;

public class CreateRoomRequestDTO {

    private BigDecimal price;

    private RoomType type;

    private Status status;

    public CreateRoomRequestDTO() {

    }

    public CreateRoomRequestDTO(BigDecimal price, RoomType type, Status status) {
        this.price = price;
        this.type = type;
        this.status = status;
    }

    public Room toEntity() {
        return new Room(this.type, this.price, this.status);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
