package com.rama.trour.service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Rakesh Jha
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "The given username is already in use.")
public class UsernameAlreadyInUseException extends RuntimeException {
}