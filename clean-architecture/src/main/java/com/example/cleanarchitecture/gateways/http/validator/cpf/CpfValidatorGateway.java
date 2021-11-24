package com.example.cleanarchitecture.gateways.http.validator.cpf;

import com.example.cleanarchitecture.domains.enums.VoteCheck;

public interface CpfValidatorGateway {
    VoteCheck validateCpfToEnableToVote(final String cpf);
}
