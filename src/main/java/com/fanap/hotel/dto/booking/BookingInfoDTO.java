package com.fanap.hotel.dto.booking;

import java.time.LocalDate;
import java.util.List;

public class BookingInfoDTO {

    private Long roomId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private LocalDate bookingDate;

    private List<Long> additionalServiceIds;

    public BookingInfoDTO() {

    }

    public BookingInfoDTO(Long roomId, LocalDate checkInDate, LocalDate checkOutDate, LocalDate bookingDate, List<Long> additionalServiceIds) {
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingDate = bookingDate;
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

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public List<Long> getAdditionalServiceIds() {
        return additionalServiceIds;
    }

    public void setAdditionalServiceIds(List<Long> additionalServiceIds) {
        this.additionalServiceIds = additionalServiceIds;
    }
}
