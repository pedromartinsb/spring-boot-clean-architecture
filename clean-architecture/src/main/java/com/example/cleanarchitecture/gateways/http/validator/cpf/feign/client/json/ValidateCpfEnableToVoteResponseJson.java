package com.example.cleanarchitecture.gateways.http.validator.cpf.feign.client.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ValidateCpfEnableToVoteResponseJson {
    private String status;
}
