package com.danamon.fundtransfer.fundtransferdanamonbe.service.impl;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.FundTransferRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.FundTransferResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.mapper.FundTransferMapper;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.FundTransferRepository;
import com.danamon.fundtransfer.fundtransferdanamonbe.service.FundTransferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FundTransferServiceImpl implements FundTransferService {

    @Autowired
    private FundTransferRepository repository;

    @Autowired
    private FundTransferMapper mapper;

    @Override
    public FundTransferResponse requestFundTransfer(FundTransferRequest request) {
        var fundTransfer = mapper.requestFundTransfer(request);
        var result = repository.save(fundTransfer);
        return mapper.responseFundTransfer(result);
    }

    @Override
    public List<FundTransferResponse> findAll() {
        var listFundTransfer = repository.findAll();
        return listFundTransfer.stream().map(mapper::responseFundTransfer).collect(Collectors.toList());
    }
}
