package com.rama.trour.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rama.trour.model.ServiceError;

import javax.ws.rs.NotFoundException;

/**
 * @author Rakesh Jha
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ServiceError handleNotFoundException(NotFoundException notFoundException) {
        return new ServiceError(notFoundException);
    }
}