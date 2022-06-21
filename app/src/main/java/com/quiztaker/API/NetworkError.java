package com.quiztaker.API;

public class NetworkError {
    private int errorCode;
    private String errorMessage;

    public NetworkError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public NetworkError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
