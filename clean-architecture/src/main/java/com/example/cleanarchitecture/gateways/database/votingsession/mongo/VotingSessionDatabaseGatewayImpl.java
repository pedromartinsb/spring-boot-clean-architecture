package com.example.cleanarchitecture.gateways.database.votingsession.mongo;

import java.util.Optional;

import com.example.cleanarchitecture.domains.VotingSession;
import com.example.cleanarchitecture.gateways.database.votingsession.VotingSessionDatabaseGateway;
import com.example.cleanarchitecture.gateways.database.votingsession.mongo.repository.VotingSessionRepository;
import com.example.cleanarchitecture.gateways.exceptions.FindVotingSessionByIdDatabaseException;
import com.example.cleanarchitecture.gateways.exceptions.OpenVotingSessionDatabaseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class VotingSessionDatabaseGatewayImpl implements VotingSessionDatabaseGateway {

    @Autowired
    private VotingSessionRepository sessionRepository;

    @Override
    public Optional<VotingSession> findById(String id) {
        log.info("id: {}", id);
        try {
            return this.sessionRepository.findById(id);
        } catch (Exception e) {
            log.error("error: {}", e);
            throw new FindVotingSessionByIdDatabaseException();
        }
    }

    @Override
    public VotingSession open(VotingSession votingSession) {
        log.info("votingSession: {}", votingSession);
        try {
            return this.sessionRepository.save(votingSession);
        } catch (Exception e) {
            log.error("error: {}", e);
            throw new OpenVotingSessionDatabaseException();
        }
    }
    
}
