package com.hsbc.exceptions;

public class InsufficientCreditsException extends Exception {
    public InsufficientCreditsException(String message) {
        super(message);
    }

    public InsufficientCreditsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientCreditsException(Throwable cause) {
        super(cause);
    }
}
