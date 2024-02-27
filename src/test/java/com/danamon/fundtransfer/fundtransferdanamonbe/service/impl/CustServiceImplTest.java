package com.danamon.fundtransfer.fundtransferdanamonbe.service.impl;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustProfileRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustGetDataResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.*;
import com.danamon.fundtransfer.fundtransferdanamonbe.mapper.CustMapper;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.util.ReflectionTestUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustServiceImplTest {

    @Mock
    private CustRepository mockCustRepository;
    @Mock
    private CustProfileRepository mockCustProfileRepository;
    @Mock
    private AcctRepository mockAcctRepository;
    @Mock
    private CustRelRepository mockCustRelRepository;
    @Mock
    private CustGetDataRepository mockCustGetDataRepository;
    @Mock
    private IntegrationLogRepository mockIntegrationLogRepository;
    @Mock
    private CustMapper mockCustMapper;
    @Mock
    private EntityManager mockEntityManager;

    @InjectMocks
    private CustServiceImpl custServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(custServiceImplUnderTest, "cookieName", "cookieName");
        custServiceImplUnderTest.custMapper = mockCustMapper;
        custServiceImplUnderTest.entityManager = mockEntityManager;
    }

    @Test
    void testDataResponse() {
        // Setup
        final MockHttpServletRequest requestServlet = new MockHttpServletRequest();
        final MockHttpServletResponse response = new MockHttpServletResponse();

        // Configure CustGetDataRepository.getData(...).
        final List<CustGetDataResponse> custGetDataResponses = List.of(CustGetDataResponse.builder()
                .username("createdBy")
                .build());
        when(mockCustGetDataRepository.getData("username")).thenReturn(custGetDataResponses);

        // Run the test
        final List<CustGetDataResponse> result = custServiceImplUnderTest.dataResponse(requestServlet, response,
                "username");

        // Verify the results
        verify(mockIntegrationLogRepository).save(any(IntegrationLog.class));
    }

}
