package com.rama.trour.model;

/**
 * @author Rakesh Jha
 */
public class ServiceError {
    private String error;
    private String message;

    public ServiceError(Exception exception) {
        this.message = exception.getMessage();
        this.error = exception.getClass().getSimpleName();
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
