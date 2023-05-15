package com.vnc.dslist.services.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends Exception {
    
    private static final long serialVersionUID = 1L;

    private HttpStatus status;

    public ResourceNotFoundException(String msg, HttpStatus status) {
        super(msg);
        this.status = status;
    }
}
