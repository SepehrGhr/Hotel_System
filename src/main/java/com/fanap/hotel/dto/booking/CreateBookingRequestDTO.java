package com.fanap.hotel.dto.booking;

import java.time.LocalDate;
import java.util.List;

public class CreateBookingRequestDTO {
     private Long roomId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private List<Long> additionalServiceIds;

    public CreateBookingRequestDTO(){

    }

    public CreateBookingRequestDTO(Long roomId, LocalDate checkInDate, LocalDate checkOutDate, List<Long> additionalServiceIds) {
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.additionalServiceIds = additionalServiceIds;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public List<Long> getAdditionalServiceIds() {
        return additionalServiceIds;
    }

    public void setAdditionalServiceIds(List<Long> additionalServiceIds) {
        this.additionalServiceIds = additionalServiceIds;
    }
}
