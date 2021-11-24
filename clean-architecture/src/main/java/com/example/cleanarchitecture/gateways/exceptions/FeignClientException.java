package com.example.cleanarchitecture.gateways.exceptions;

import com.example.cleanarchitecture.config.interceptors.controllers.SicrediVotingBaseException;

import org.springframework.http.HttpStatus;

public class FeignClientException extends SicrediVotingBaseException {

    private static final long serialVersionUID = 1L;

    @Override
    public String getCode() {
        return "sicredi.feign.error";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public String getMessage() {
        return "Feign error.";
    }
    
}
