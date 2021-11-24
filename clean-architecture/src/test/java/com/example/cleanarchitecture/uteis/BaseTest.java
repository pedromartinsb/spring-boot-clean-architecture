package com.example.cleanarchitecture.uteis;

import com.example.cleanarchitecture.databuilders.domains.DomainsDataBuilder;
import com.github.javafaker.Faker;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class BaseTest {
    
    protected DomainsDataBuilder domainsDataBuilder;
    protected Faker faker;

    @BeforeEach
    public void init() {
        this.domainsDataBuilder = new DomainsDataBuilder();
        this.faker = new Faker();
        MockitoAnnotations.openMocks(this);
    }
}
