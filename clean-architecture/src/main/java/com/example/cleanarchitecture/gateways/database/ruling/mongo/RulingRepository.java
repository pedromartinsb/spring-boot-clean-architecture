package com.example.cleanarchitecture.gateways.database.ruling.mongo;

import com.example.cleanarchitecture.domains.Ruling;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RulingRepository extends MongoRepository<Ruling, String> {
    
}
