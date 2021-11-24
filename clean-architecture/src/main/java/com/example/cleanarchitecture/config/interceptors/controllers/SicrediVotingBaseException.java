package com.example.cleanarchitecture.config.interceptors.controllers;

import org.springframework.http.HttpStatus;

public abstract class SicrediVotingBaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public abstract String getCode();
    public abstract HttpStatus getHttpStatus();
    public abstract String getMessage();
}
