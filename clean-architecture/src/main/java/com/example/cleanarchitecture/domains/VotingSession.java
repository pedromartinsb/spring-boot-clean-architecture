package com.example.cleanarchitecture.domains;

import java.time.LocalDateTime;

import com.mongodb.lang.NonNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.ObjectUtils;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@Document
public class VotingSession {
    
    @Id
    private String id;

    @NonNull
    @DBRef
    private Ruling ruling;

    @NonNull
    private LocalDateTime expiration;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime lastUpdate;

    public Boolean isOpen() {
        if (!ObjectUtils.isEmpty(this.expiration)) {
            final LocalDateTime localDateTimeNow = LocalDateTime.now();
            return this.expiration.isAfter(localDateTimeNow);
        }
        return false;
    }
}
