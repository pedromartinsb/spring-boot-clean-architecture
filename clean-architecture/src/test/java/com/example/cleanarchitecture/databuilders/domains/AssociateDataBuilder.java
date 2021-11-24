package com.example.cleanarchitecture.databuilders.domains;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import com.example.cleanarchitecture.databuilders.DataBuilderBase;
import com.example.cleanarchitecture.databuilders.Utils;
import com.example.cleanarchitecture.domains.Associate;

public class AssociateDataBuilder extends DataBuilderBase<Associate> {

    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;

    public AssociateDataBuilder() {
        this.id = this.faker.internet().uuid();
        this.createdAt = Utils.convertToLocalDateTime(this.faker.date().past(2, TimeUnit.DAYS));
        this.lastUpdate = Utils.convertToLocalDateTime(this.faker.date().past(2, TimeUnit.DAYS));
    }

    public AssociateDataBuilder toCreate() {
        this.id = null;
        this.createdAt = null;
        this.lastUpdate = null;
        return this;
    }

    public Associate build() {
        return Associate.builder()
            .id(id)
            .name(this.faker.name().fullName())
            .cpf(this.faker.internet().uuid())
            .createdAt(createdAt)
            .lastUpdate(lastUpdate)
            .build();
    }
    
}
