package com.example.cleanarchitecture.gateways.database.votingsession;

import java.util.Optional;

import com.example.cleanarchitecture.domains.VotingSession;

public interface VotingSessionDatabaseGateway {
    Optional<VotingSession> findById(final String id);
    VotingSession open(final VotingSession votingSession);
}
