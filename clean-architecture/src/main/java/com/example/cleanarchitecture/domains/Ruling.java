package com.example.cleanarchitecture.domains;

import java.time.LocalDateTime;

import com.mongodb.lang.NonNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
@Document
public class Ruling {
    
    @Id
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime lastUpdate;
}
