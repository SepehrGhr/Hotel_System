package com.fanap.hotel.dto.room;

import com.fanap.hotel.model.RoomType;
import com.fanap.hotel.model.Status;

import java.math.BigDecimal;

public class RoomInfoDTO {

    private RoomType type;

    private BigDecimal price;

    private Status status;

    public RoomInfoDTO(){

    }

    public RoomInfoDTO(RoomType type, BigDecimal price, Status status) {
        this.type = type;
        this.price = price;
        this.status = status;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
