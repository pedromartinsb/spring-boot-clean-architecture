package com.example.cleanarchitecture.gateways.http.validator.cpf.feign.config;

import com.example.cleanarchitecture.gateways.exceptions.CpfNotFoundException;
import com.example.cleanarchitecture.gateways.exceptions.FeignClientException;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(final String methodKey, final Response response) {
        switch (response.status()) {
            case 404:
                log.error("Error in request went through feign client: {}", response.request().body());
                return new CpfNotFoundException();
            default:
                log.error("Error in request went: {}", response);
                return new FeignClientException();
        }
    }
    
}
