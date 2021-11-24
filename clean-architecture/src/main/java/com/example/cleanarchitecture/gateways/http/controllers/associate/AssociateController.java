package com.example.cleanarchitecture.gateways.http.controllers.associate;

import javax.validation.Valid;

import com.example.cleanarchitecture.domains.Associate;
import com.example.cleanarchitecture.gateways.http.controllers.associate.json.CreateAssociateRequestJson;
import com.example.cleanarchitecture.gateways.http.controllers.associate.json.CreateAssociateResponseJson;
import com.example.cleanarchitecture.usecases.CreateAssociateUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("${baseurl.v1}/associates")
@Api(tags = "Associate", produces = MediaType.APPLICATION_JSON_VALUE)
public class AssociateController {

    @Autowired
    private CreateAssociateUseCase createAssociateUseCase;

    @ApiOperation(value = "Resource to Create Associate", response = CreateAssociateResponseJson.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "CREATED"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 422, message = "Unprocessable Entity"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    @Validated
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CreateAssociateResponseJson create(
        final @RequestBody(required = true) @Valid CreateAssociateRequestJson createAssociateRequestJson) {
            
            log.info("createAssociateRequestJson: {}", createAssociateRequestJson);
            final Associate associateToCreate = Associate.builder()
                .name(createAssociateRequestJson.getName())
                .cpf(createAssociateRequestJson.getCpf())
                .build();
            final Associate associateCreated = this.createAssociateUseCase.create(associateToCreate);
            return CreateAssociateResponseJson.builder().id(associateCreated.getId()).build();
    }
    
}
