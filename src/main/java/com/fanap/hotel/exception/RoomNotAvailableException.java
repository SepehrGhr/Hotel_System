package com.fanap.hotel.exception;

public class RoomNotAvailableException extends RuntimeException {

    public RoomNotAvailableException(Long id) {
        super("Room with id " + id + " is not available in the selected time span");
    }
}
