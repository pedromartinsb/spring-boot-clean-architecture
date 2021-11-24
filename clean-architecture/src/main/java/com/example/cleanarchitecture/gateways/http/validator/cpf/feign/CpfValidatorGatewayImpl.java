package com.example.cleanarchitecture.gateways.http.validator.cpf.feign;

import com.example.cleanarchitecture.domains.enums.VoteCheck;
import com.example.cleanarchitecture.gateways.http.validator.cpf.CpfValidatorGateway;
import com.example.cleanarchitecture.gateways.http.validator.cpf.feign.client.CpfValidatorFeignClient;
import com.example.cleanarchitecture.gateways.http.validator.cpf.feign.client.json.ValidateCpfEnableToVoteResponseJson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CpfValidatorGatewayImpl implements CpfValidatorGateway {
    
    final String ABLE_TO_VOTE = "ABLE_TO_VOTE";
    final String UNABLE_TO_VOTE = "UNABLE_TO_VOTE";

    @Autowired
    private CpfValidatorFeignClient cpfValidatorFeignClient;
    
    @Override
    public VoteCheck validateCpfToEnableToVote(String cpf) {
        log.info("cpf: {}", cpf);
        final ValidateCpfEnableToVoteResponseJson response = 
            this.cpfValidatorFeignClient.validateCpfEnableToVoteFinal(cpf);
            
        if (response.getStatus().equals(ABLE_TO_VOTE)) {
            return VoteCheck.ENALE;
        } else {
            return VoteCheck.DISABLE;
        }
    }
    
}
