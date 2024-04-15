package com.example.leaderboard.exception;

public class BadDataProvidedException extends RuntimeException {
    private String errorCode;

    public BadDataProvidedException() {
        super();
    }

    public BadDataProvidedException(String msg) {
        super(msg);
    }

    public BadDataProvidedException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
