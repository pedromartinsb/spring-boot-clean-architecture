package com.example.cleanarchitecture.gateways.http.controllers.associate.json;

import javax.validation.constraints.NotEmpty;

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
public class CreateAssociateRequestJson {
    
    @NotEmpty(message = "Field name is required.")
    private String name;

    @NotEmpty(message = "Field cpf is required.")
    private String cpf;
}
