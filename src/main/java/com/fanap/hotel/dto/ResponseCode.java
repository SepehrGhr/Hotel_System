package com.fanap.hotel.dto;

public enum ResponseCode {
    SUCCESS(0),
    ERROR(1),
    NOT_FOUND(404);

    private final int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
