package com.fanap.hotel.dto;

public enum ResponseMessage {
    SUCCESS("Request processed successfully"),
    FAILED("REQUEST_PROCESS_FAILED"),
    ERROR("Something went wrong"),
    NOT_FOUND("Resource not found");

    private final String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
