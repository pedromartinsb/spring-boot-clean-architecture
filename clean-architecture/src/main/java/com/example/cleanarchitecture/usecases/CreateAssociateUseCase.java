package com.example.cleanarchitecture.usecases;

import java.util.Optional;

import com.example.cleanarchitecture.domains.Associate;
import com.example.cleanarchitecture.gateways.database.associate.AssociateDatabaseGateway;
import com.example.cleanarchitecture.usecases.exceptions.AssociateAlreadyExistsWithCpfException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CreateAssociateUseCase {

    @Autowired
    private AssociateDatabaseGateway associateDatabaseGateway;

    @Autowired
    private FindAssociateByCpfUseCase findAssociateByCpfUseCase;

    public Associate create(final Associate associateToCreate) {
        log.info("associateToCreate: {}", associateToCreate);
        final Optional<Associate> associateOptional = this.findAssociateByCpfUseCase.find(associateToCreate.getCpf());
        this.checkAssociateAlreadyExists(associateOptional);
        return this.associateDatabaseGateway.create(associateToCreate);
    }

    private void checkAssociateAlreadyExists(final Optional<Associate> associateOptional) {
        if (associateOptional.isPresent()) {
            throw new AssociateAlreadyExistsWithCpfException();
        }
    }
    
}
