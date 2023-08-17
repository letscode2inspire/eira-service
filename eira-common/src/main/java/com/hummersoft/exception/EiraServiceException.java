package com.hummersoft.exception;

import lombok.Getter;

@Getter
public class EiraServiceException extends RuntimeException{

    private final int statusCode;

    private String errorMessage;

    public EiraServiceException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public EiraServiceException(int statusCode) {
        this.statusCode = statusCode;
    }

    public EiraServiceException(String errorMessage) {
        this.errorMessage = errorMessage;
        this.statusCode = -1;
    }

    public EiraServiceException(Exception e) {
        super(e);
        this.statusCode = -1;
        this.errorMessage = null;
    }

}
