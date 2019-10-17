package com.stackroute.muzix.exception;


public class TrackNoteFoundException extends Exception {
    private String  message;
    public TrackNoteFoundException(){}
    public TrackNoteFoundException(String message){
        super(message);
        this.message=message;
    }
}
