package com.example.cleanarchitecture.gateways.database.ruling;

import com.example.cleanarchitecture.domains.Ruling;

public interface RulingDatabaseGateway {
    Ruling create(final Ruling rulingToCreate);
}
