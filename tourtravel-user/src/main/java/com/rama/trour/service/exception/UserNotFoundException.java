package com.rama.trour.service.exception;

import javax.ws.rs.NotFoundException;

/**
 * @author Rakesh Jha
 */
public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(String message) {
        super(message);
    }
}