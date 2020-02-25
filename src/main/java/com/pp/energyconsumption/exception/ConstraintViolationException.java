package com.pp.energyconsumption.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author prathameshpawar
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConstraintViolationException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
 
    public ConstraintViolationException(String message) {
        super(message);
    }
}
