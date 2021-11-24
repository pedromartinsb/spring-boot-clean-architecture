package com.example.cleanarchitecture.domains;

import java.time.LocalDateTime;

import com.example.cleanarchitecture.domains.enums.VoteType;
import com.mongodb.lang.NonNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@Document
public class Vote {
    
    @Id
    private String id;

    @NonNull
    private VoteType voteType;

    @NonNull
    @DBRef
    private Associate associate;

    @NonNull
    @DBRef
    private VotingSession votingSession;

    @CreatedDate
    private LocalDateTime createdAt;
}
