package com.example.cleanarchitecture.usecases;

import java.util.Optional;

import com.example.cleanarchitecture.domains.Associate;
import com.example.cleanarchitecture.gateways.database.associate.AssociateDatabaseGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FindAssociateByCpfUseCase {

    @Autowired
    private AssociateDatabaseGateway associateDatabaseGateway;

    public Optional<Associate> find(final String cpf) {
        log.info("cpf: {}", cpf);
        return this.associateDatabaseGateway.findByCpf(cpf);
    }
    
}
