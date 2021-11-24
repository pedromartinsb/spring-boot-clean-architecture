package com.example.cleanarchitecture.gateways.database.associate.mongo;

import java.util.Optional;

import com.example.cleanarchitecture.domains.Associate;
import com.example.cleanarchitecture.gateways.database.associate.AssociateDatabaseGateway;
import com.example.cleanarchitecture.gateways.database.associate.mongo.repository.AssociateRepository;
import com.example.cleanarchitecture.gateways.exceptions.CreateAssociateDatabaseException;
import com.example.cleanarchitecture.gateways.exceptions.FindAssociateByCpfDatabaseException;
import com.example.cleanarchitecture.gateways.exceptions.FindAssociateByIdDatabaseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AssociateDatabaseGatewayImpl implements AssociateDatabaseGateway {
    
    @Autowired
    private AssociateRepository associateRepository;

    @Override
    public Associate create(Associate associateToCreate) {
        log.info("associateToCreate: {}", associateToCreate);
        try {
            return this.associateRepository.save(associateToCreate);
        } catch (Exception e) {
            log.error("error: {}", e);
            throw new CreateAssociateDatabaseException();
        }
    }

    @Override
    public Optional<Associate> findByCpf(String cpf) {
        log.info("cpf: {}", cpf);
        try {
            return this.associateRepository.findByCpf(cpf);
        } catch (Exception e) {
            log.error("error: {}", e);
            throw new FindAssociateByCpfDatabaseException();
        }
    }

    @Override
    public Optional<Associate> findById(String id) {
        log.info("id: {}", id);
        try {
            return this.associateRepository.findById(id);
        } catch (Exception e) {
            log.error("error: {}", e);
            throw new FindAssociateByIdDatabaseException();
        }
    } 
}
