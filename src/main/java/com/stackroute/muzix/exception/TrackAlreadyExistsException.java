package com.stackroute.muzix.exception;

public class TrackAlreadyExistsException extends Exception {
    private String string;
    public TrackAlreadyExistsException() {
    }

    public TrackAlreadyExistsException(String message) {
        super(message);
        this.string = message;
    }
}
