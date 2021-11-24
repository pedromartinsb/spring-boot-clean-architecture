package com.example.cleanarchitecture.gateways.http.controllers.result;

import javax.validation.constraints.NotEmpty;

import com.example.cleanarchitecture.domains.Result;
import com.example.cleanarchitecture.gateways.http.controllers.result.json.GetResultResponseJson;
import com.example.cleanarchitecture.usecases.GetResultVotingSessionUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("${baseurl.v1}/results")
@Api(tags = "Result", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResultController {
    
    @Autowired
    private GetResultVotingSessionUseCase getResultVotingSessionUseCase;

    @ApiOperation(value = "Resourxe to get result voting session", response = GetResultResponseJson.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 422, message = "Unprocessable Entity"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @Validated
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("finish/{votingSessionId}")
    public GetResultResponseJson getResult(final @PathVariable(name = "votingSessionId") @NotEmpty String votingSessionId) {
        log.info("votindSessionId: {}", votingSessionId);
        final Result result = this.getResultVotingSessionUseCase.getResult(votingSessionId);
        return GetResultResponseJson.builder().no(result.getNo())
            .yes(result.getYes())
            .winner(result.getWinner())
            .build();
    } 
}
