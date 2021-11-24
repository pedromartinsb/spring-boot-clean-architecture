package com.example.cleanarchitecture.gateways.database.associate;

import java.util.Optional;

import com.example.cleanarchitecture.domains.Associate;

public interface AssociateDatabaseGateway {
    Associate create(final Associate associateToCreate);
    Optional<Associate> findByCpf(final String cpf);
    Optional<Associate> findById(final String id);    
}
