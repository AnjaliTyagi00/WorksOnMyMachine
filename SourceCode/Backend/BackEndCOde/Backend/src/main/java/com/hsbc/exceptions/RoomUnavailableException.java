package com.hsbc.exceptions;

public class RoomUnavailableException extends Exception {
    public RoomUnavailableException(String message) {
        super(message);
    }

    public RoomUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomUnavailableException(Throwable cause) {
        super(cause);
    }
}
