package com.example.cleanarchitecture.usecases;

import java.util.Optional;

import com.example.cleanarchitecture.domains.VotingSession;
import com.example.cleanarchitecture.gateways.database.votingsession.VotingSessionDatabaseGateway;
import com.example.cleanarchitecture.usecases.exceptions.VotingSessionIsClosedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FindVotingSessionByIdUseCase {
    
    @Autowired
    public VotingSessionDatabaseGateway votingSessionDatabaseGateway;

    public VotingSession find(final String id) {
        log.info("id: {}", id);
        final Optional<VotingSession> optionalVotingSession = this.votingSessionDatabaseGateway.findById(id);
        if (!optionalVotingSession.isPresent()) {
            log.warn("voting session not found: {}", id);
            throw new VotingSessionIsClosedException();
        }
        return optionalVotingSession.get();
    }
}
