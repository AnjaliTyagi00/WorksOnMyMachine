package com.hsbc.exceptions;

public class MeetingNotFoundException extends Exception {
    public MeetingNotFoundException(String message) {
        super(message);
    }

    public MeetingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeetingNotFoundException(Throwable cause) {
        super(cause);
    }
}
