package com.example.cleanarchitecture.databuilders.domains;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import com.example.cleanarchitecture.databuilders.DataBuilderBase;
import com.example.cleanarchitecture.databuilders.Utils;
import com.example.cleanarchitecture.domains.Ruling;

public class RulingDataBuilder extends DataBuilderBase<Ruling> {

    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;

    public RulingDataBuilder() {
        this.id = this.faker.internet().uuid();
        this.createdAt = Utils.convertToLocalDateTime(this.faker.date().past(2, TimeUnit.DAYS));
        this.lastUpdate = Utils.convertToLocalDateTime(this.faker.date().past(2, TimeUnit.DAYS));
    }

    public RulingDataBuilder toCreate() {
        this.id = null;
        this.createdAt = null;
        this.lastUpdate = null;
        return this;
    }

    public Ruling build() {
        return Ruling.builder()
            .id(id)
            .name(this.faker.company().name())
            .description(this.faker.lorem().paragraph())
            .createdAt(createdAt)
            .lastUpdate(lastUpdate)
            .build();
    }
    
}
