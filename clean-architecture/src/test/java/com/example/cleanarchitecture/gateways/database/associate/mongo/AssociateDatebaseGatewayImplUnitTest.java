package com.example.cleanarchitecture.gateways.database.associate.mongo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.cleanarchitecture.domains.Associate;
import com.example.cleanarchitecture.gateways.database.associate.mongo.repository.AssociateRepository;
import com.example.cleanarchitecture.uteis.BaseTest;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.VerificationModeFactory;

public class AssociateDatebaseGatewayImplUnitTest extends BaseTest {

    @InjectMocks
    private AssociateDatabaseGatewayImpl associateDatabaseGatewayImpl;

    @Mock
    private AssociateRepository associateRepository;

    @Test
    @DisplayName("Should by create associate success")
    public void shouldBySuccess() {
        final Associate associateToCreate = this.domainsDataBuilder.getAssociateDataBuilder().toCreate().build();
        final Associate associateCreated = this.domainsDataBuilder.getAssociateDataBuilder().build();

        when(this.associateRepository.save(any(Associate.class))).thenReturn(associateCreated);

        final Associate response = this.associateDatabaseGatewayImpl.create(associateToCreate);
        final ArgumentCaptor<Associate> associateCaptor = ArgumentCaptor.forClass(Associate.class);
        verify(this.associateRepository, VerificationModeFactory.times(1)).save(associateCaptor.capture());
        final Associate associateCaptured = associateCaptor.getValue();
        this.assertResponse(associateCreated, response);
		this.assertCaptured(associateToCreate, associateCaptured);
    }

    private void assertCaptured(final Associate associateToCreate, final Associate associateCaptured) {
        assertEquals(associateToCreate.getCpf(), associateCaptured.getCpf());
        assertEquals(associateToCreate.getName(), associateCaptured.getName());
        assertEquals(null, associateCaptured.getId());
        assertEquals(null, associateCaptured.getCreatedAt());
        assertEquals(null, associateCaptured.getLastUpdate());
    }

    private void assertResponse(final Associate associateCreated, final Associate response) {
        assertEquals(associateCreated.getId(), response.getId());
        assertEquals(associateCreated.getCpf(), response.getCpf());
        assertEquals(associateCreated.getName(), response.getName());
        assertEquals(associateCreated.getCreatedAt(), response.getCreatedAt());
        assertEquals(associateCreated.getLastUpdate(), response.getLastUpdate());
    }
    
}
