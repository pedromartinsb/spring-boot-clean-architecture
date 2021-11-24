package com.example.cleanarchitecture.gateways.http.validator.cpf.feign.client;

import javax.validation.Valid;

import com.example.cleanarchitecture.gateways.http.validator.cpf.feign.client.json.ValidateCpfEnableToVoteResponseJson;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${feign.cpfValidator.name}", url = "${feign.cpfValidator.url}")
public interface CpfValidatorFeignClient {
    
    @GetMapping("users/{cpf}")
    ValidateCpfEnableToVoteResponseJson validateCpfEnableToVoteFinal(@PathVariable(name = "cpf") @Valid String cpf);
}
