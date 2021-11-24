package com.example.cleanarchitecture.databuilders.domains;

import lombok.Getter;

@Getter
public class DomainsDataBuilder {
    
    private RulingDataBuilder rulingDataBuilder;
	private AssociateDataBuilder associateDataBuilder;
	private VoteDataBuilder volteDataBuilder;
	private VotingSessionDataBuilder votingSessionDataBuilder;
	private ResultDataBuilder resultDataBuilder;

	public DomainsDataBuilder() {
		this.rulingDataBuilder = new RulingDataBuilder();
		this.associateDataBuilder = new AssociateDataBuilder();
		this.volteDataBuilder = new VoteDataBuilder();
		this.votingSessionDataBuilder = new VotingSessionDataBuilder();
		this.resultDataBuilder = new ResultDataBuilder();
	}
    
}
