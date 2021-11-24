package com.example.cleanarchitecture.gateways.database.ruling.mongo;

import com.example.cleanarchitecture.domains.Ruling;
import com.example.cleanarchitecture.gateways.database.ruling.RulingDatabaseGateway;
import com.example.cleanarchitecture.gateways.exceptions.CreateRulingDatabaseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RulingDatabaseGatewayImpl implements RulingDatabaseGateway {
    
    @Autowired
    private RulingRepository rulingRepository;
    
    @Override
    public Ruling create(Ruling rulingToCreate) {
        log.info("rulingToCreate: {}", rulingToCreate);
        try {
            return this.rulingRepository.save(rulingToCreate);
        } catch (Exception e) {
            log.error("error: {}", e);
            throw new CreateRulingDatabaseException();
        }
    }
    
}
