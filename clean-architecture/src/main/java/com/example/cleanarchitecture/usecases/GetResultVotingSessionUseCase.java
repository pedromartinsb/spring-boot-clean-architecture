package com.example.cleanarchitecture.usecases;

import java.util.List;
import java.util.stream.Collectors;

import com.example.cleanarchitecture.domains.Result;
import com.example.cleanarchitecture.domains.Vote;
import com.example.cleanarchitecture.domains.VotingSession;
import com.example.cleanarchitecture.domains.enums.VoteType;
import com.example.cleanarchitecture.domains.enums.Winner;
import com.example.cleanarchitecture.usecases.exceptions.VotingSessionIsStillOpenException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GetResultVotingSessionUseCase {

    @Autowired
    private FindVotingSessionByIdUseCase findVotingSessionByIdUseCase;

    @Autowired
    private FindVotesByVotingSessionUseCase findVotesByVotingSessionUseCase;
    
    public Result getResult(final String votingSessionId) {
        log.info("votingSessionId: {}", votingSessionId);
        final VotingSession votingSessionFinded = this.findVotingSessionByIdUseCase.find(votingSessionId);
        this.checkVotingSessionIsStillOpen(votingSessionFinded);
        final List<Vote> votesBySession = this.findVotesByVotingSessionUseCase.find(votingSessionId);
        final Integer totalVotesNo = this.getTotalVotes(votesBySession, VoteType.NO);
        final Integer totalVotesYes = this.getTotalVotesYes(votesBySession, totalVotesNo);
        final Winner winner = this.getWinner(totalVotesNo, totalVotesYes);
        return Result.builder().yes(totalVotesYes).no(totalVotesNo)
            .winner(winner).build();
    }

    private Winner getWinner(final Integer totalVotesNo, final Integer totalVotesYes) {
        return totalVotesNo.equals(totalVotesYes) ? Winner.TIE
            : totalVotesNo > totalVotesYes ? Winner.NO : Winner.YES;
    }

    private Integer getTotalVotesYes(final List<Vote> votesBySession, final Integer totalVotesNo) {
        return votesBySession.size() - totalVotesNo;
    }

    private Integer getTotalVotes(final List<Vote> votesBySession, final VoteType voteType) {
        return votesBySession.stream().filter(vote -> vote.getVoteType().equals(voteType)).collect(Collectors.toList()).size();
    }

    private void checkVotingSessionIsStillOpen(final VotingSession votingSessionFinded) {
        if (votingSessionFinded.isOpen()) {
            throw new VotingSessionIsStillOpenException();
        }
    }
}
