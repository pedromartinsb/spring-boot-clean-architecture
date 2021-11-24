package com.example.cleanarchitecture.gateways.database.associate.mongo.repository;

import java.util.Optional;

import com.example.cleanarchitecture.domains.Associate;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssociateRepository extends MongoRepository<Associate, String> {
    Optional<Associate> findByCpf(final String cpf);
}
