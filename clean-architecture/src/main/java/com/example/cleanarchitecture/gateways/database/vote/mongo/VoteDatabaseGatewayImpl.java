package com.example.cleanarchitecture.gateways.database.vote.mongo;

import java.util.List;
import java.util.Optional;

import com.example.cleanarchitecture.domains.Vote;
import com.example.cleanarchitecture.gateways.database.vote.VoteDatabaseGateway;
import com.example.cleanarchitecture.gateways.database.vote.mongo.repository.VoteRepository;
import com.example.cleanarchitecture.gateways.exceptions.CreateVoteDatabaseException;
import com.example.cleanarchitecture.gateways.exceptions.FindAllVotesByVotingSessionDatabaseException;
import com.example.cleanarchitecture.gateways.exceptions.FindVoteBySessionIdAndAssciateIdAssociateDatabaseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class VoteDatabaseGatewayImpl implements VoteDatabaseGateway {
    
    @Autowired
    private VoteRepository voteRepository;
    
    @Override
    public Vote create(Vote voteToCreate) {
        log.info("voteToCreate: {}", voteToCreate);
        try {
            return this.voteRepository.save(voteToCreate);
        } catch (Exception e) {
            log.error("error: {}", e);
            throw new CreateVoteDatabaseException();
        }
    }

    @Override
    public Optional<Vote> findByAssociateIdAndVotingSessionId(String votingSessionId, String associateId) {
        log.info("associateId: {}, votingSessionId: {}", associateId, votingSessionId);
        try {
            return this.voteRepository.findByAssociateIdAndVotingSessionId(associateId, votingSessionId);
        } catch (Exception e) {
            log.error("error: {}", e);
            throw new FindVoteBySessionIdAndAssciateIdAssociateDatabaseException();
        }
    }

    @Override
    public List<Vote> findAllByVotingSessionId(String votingSessionId) {
        log.info("votingSessionId: {}", votingSessionId);
        try {
            return this.voteRepository.findAllByVotingSessionId(votingSessionId);
        } catch (Exception e) {
            log.error("error: {}", e);
            throw new FindAllVotesByVotingSessionDatabaseException();
        }
    }
    
}
