package com.fanap.hotel.util.constants;

public enum ResponseCodePool {

    REQUEST_PROCESSED_SUCCESSFULLY(0, "request_processed_successfully"),
    INVALID_REQUEST_BODY(10, "invalid_request_body"),
    ROOM_DELETED(100, "room_deleted");

    private final Integer code;
    private final String message;

    ResponseCodePool(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
