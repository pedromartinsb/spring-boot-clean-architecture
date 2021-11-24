package com.example.cleanarchitecture.gateways.database.votingsession.mongo.repository;

import com.example.cleanarchitecture.domains.VotingSession;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotingSessionRepository extends MongoRepository<VotingSession, String> {
    
}
