package com.danamon.fundtransfer.fundtransferdanamonbe.service.impl;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.FundTransferRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.FundTransferResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.FundTransfer;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.IntegrationLog;
import com.danamon.fundtransfer.fundtransferdanamonbe.mapper.FundTransferMapper;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.FundTransferRepository;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.IntegrationLogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FundTransferServiceImplTest {

    @Mock
    private FundTransferRepository mockRepository;
    @Mock
    private IntegrationLogRepository mockIntegrationLogRepository;
    @Mock
    private FundTransferMapper mockMapper;

    @InjectMocks
    private FundTransferServiceImpl fundTransferServiceImplUnderTest;

    @Test
    void testFindAll() {
        // Setup
        when(mockRepository.findAll()).thenReturn(List.of(FundTransfer.builder().build()));
        when(mockMapper.responseFundTransfer(any(FundTransfer.class)))
                .thenReturn(FundTransferResponse.builder().build());

        // Run the test
        final List<FundTransferResponse> result = fundTransferServiceImplUnderTest.findAll();

        // Verify the results
    }

    @Test
    void testFindAll_FundTransferRepositoryReturnsNoItems() {
        // Setup
        when(mockRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<FundTransferResponse> result = fundTransferServiceImplUnderTest.findAll();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
