package com.example.leaderboard.dto;

public class ErrorResponse {
    private Integer errorCode;
    private String errorResponse;
    private String errorMessage;

    public ErrorResponse() {
    }

    public ErrorResponse(Integer errorCode, String errorResponse, String errorMessage) {
        this.errorCode = errorCode;
        this.errorResponse = errorResponse;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(String errorResponse) {
        this.errorResponse = errorResponse;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
