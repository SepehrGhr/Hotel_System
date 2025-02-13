package com.fanap.hotel.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum RoomType {
    STANDARD,
    DELUXE,
    SWEET;

    @JsonCreator
    public static RoomType fromString(String value) {
        for (RoomType type : RoomType.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid RoomType: " + value);
    }
}
