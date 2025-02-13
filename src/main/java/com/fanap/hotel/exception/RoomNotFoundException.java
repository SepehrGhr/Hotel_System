package com.fanap.hotel.exception;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(Long id) {
        super("Room with ID " + id + " not found.");
    }
}

