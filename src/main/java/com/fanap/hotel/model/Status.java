package com.fanap.hotel.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Status {
    RESERVED,
    AVAILABLE;

    @JsonCreator
    public static Status fromString(String value) {
        for (Status type : Status.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid Status: " + value);
    }
}
