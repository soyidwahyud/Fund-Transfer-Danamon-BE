package com.danamon.fundtransfer.fundtransferdanamonbe.service.impl;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.FundTransferRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.FundTransferResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.IntegrationLog;
import com.danamon.fundtransfer.fundtransferdanamonbe.mapper.FundTransferMapper;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.FundTransferRepository;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.IntegrationLogRepository;
import com.danamon.fundtransfer.fundtransferdanamonbe.service.FundTransferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FundTransferServiceImpl implements FundTransferService {

    @Autowired
    private FundTransferRepository repository;

    @Autowired
    private IntegrationLogRepository integrationLogRepository;

    @Autowired
    private FundTransferMapper mapper;

    @Override
    @CachePut(value="fundTransferImpl",key = "#id", condition = "#result != null ")
    public FundTransferResponse requestFundTransfer(HttpServletRequest requestServlet, HttpServletResponse response, FundTransferRequest request) {
        var fundTransfer = mapper.requestFundTransfer(request);
        var result = repository.save(fundTransfer);

        integrationLogRepository.save(
                IntegrationLog.builder()
                        .correlationId(UUID.randomUUID().toString())
                        .activity(Thread.currentThread().getStackTrace()[1].getMethodName())
                        .connectString(requestServlet.getRequestURL().toString())
                        .createdBy(request.getSenderName())
                        .createdTime(new Date(new Date().getTime() + (7 * 60 * 60 * 1000)))
                        .requestJson(request.toString())
                        .responseJson(mapper.responseFundTransfer(result).toString())
                        .requestMethod(requestServlet.getMethod())
                        .responseTime(System.currentTimeMillis())
                        .statusCode(response.getStatus())
                        .build()
        );

        return mapper.responseFundTransfer(result);
    }

    @Override
    @Cacheable("fundTransferCache")
    public List<FundTransferResponse> findAll() {
        var listFundTransfer = repository.findAll();
        return listFundTransfer.stream().map(mapper::responseFundTransfer).collect(Collectors.toList());
    }
}
