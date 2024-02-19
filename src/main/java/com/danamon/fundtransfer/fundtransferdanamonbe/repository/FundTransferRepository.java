package com.danamon.fundtransfer.fundtransferdanamonbe.repository;

import com.danamon.fundtransfer.fundtransferdanamonbe.entity.FundTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundTransferRepository extends JpaRepository<FundTransfer, String> {
}
