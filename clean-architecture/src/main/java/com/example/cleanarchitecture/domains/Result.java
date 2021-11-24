package com.example.cleanarchitecture.domains;

import com.example.cleanarchitecture.domains.enums.Winner;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Result {

    private Integer yes;

    private Integer no;

    private Winner winner;
    
}
