package com.example.cleanarchitecture.usecases;

import java.util.List;

import com.example.cleanarchitecture.domains.Vote;
import com.example.cleanarchitecture.gateways.database.vote.VoteDatabaseGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FindVotesByVotingSessionUseCase {
    
    @Autowired
    private VoteDatabaseGateway voteDatabaseGateway;

    public List<Vote> find(final String votingSessionId) {
        log.info("votingSessionId: {}", votingSessionId);
        return this.voteDatabaseGateway.findAllByVotingSessionId(votingSessionId);
    }
}
