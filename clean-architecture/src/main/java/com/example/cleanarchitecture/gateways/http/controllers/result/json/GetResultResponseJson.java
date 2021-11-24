package com.example.cleanarchitecture.gateways.http.controllers.result.json;

import com.example.cleanarchitecture.domains.enums.Winner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GetResultResponseJson {
    private Integer yes;
    private Integer no;
    private Winner winner;
}
