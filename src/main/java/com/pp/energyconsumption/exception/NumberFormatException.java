package com.pp.energyconsumption.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author prathameshpawar
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NumberFormatException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
 
    public NumberFormatException(String message) {
        super(message);
    }
}
