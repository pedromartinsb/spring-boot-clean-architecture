package com.example.cleanarchitecture.usecases.exceptions;

import com.example.cleanarchitecture.config.interceptors.controllers.SicrediVotingBaseException;

import org.springframework.http.HttpStatus;

public class AssociateAlreadyExistsWithCpfException extends SicrediVotingBaseException {

    @Override
    public String getCode() {
        return "sicred.associate.error.associateAlreadyExistWithCpf";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }

    @Override
    public String getMessage() {
        return "Associate already exists with cpf.";
    }
    
}
