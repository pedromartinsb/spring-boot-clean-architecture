package com.example.cleanarchitecture.gateways.database.vote.mongo.repository;

import java.util.List;
import java.util.Optional;

import com.example.cleanarchitecture.domains.Vote;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoteRepository extends MongoRepository<Vote, String> {
    Optional<Vote> findByAssociateIdAndVotingSessionId(String associateId, String votingSessionId);
    List<Vote> findAllByVotingSessionId(String votingSessionId);    
}
