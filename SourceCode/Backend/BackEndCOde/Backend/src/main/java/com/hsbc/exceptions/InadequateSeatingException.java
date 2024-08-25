package com.hsbc.exceptions;

public class InadequateSeatingException extends Exception {
    public InadequateSeatingException(String message) {
        super(message);
    }

    public InadequateSeatingException(String message, Throwable cause) {
        super(message, cause);
    }

    public InadequateSeatingException(Throwable cause) {
        super(cause);
    }
}
