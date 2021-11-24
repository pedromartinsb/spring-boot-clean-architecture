package com.example.cleanarchitecture.config.interceptors.controllers.json;

import com.example.cleanarchitecture.config.interceptors.controllers.SicrediVotingBaseException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionJson {
    private final String code;
    private final String message;
    
    public ExceptionJson(final SicrediVotingBaseException baseException) {
        this.code = baseException.getCode();
        this.message = baseException.getMessage();
    }
}
