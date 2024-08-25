package com.hsbc.exceptions;

public class BookingNotFound extends Exception {
    public BookingNotFound(String message) {
        super(message);
    }

    public BookingNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public BookingNotFound(Throwable cause) {
        super(cause);
    }




}
