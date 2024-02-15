package com.danamon.fundtransfer.fundtransferdanamonbe.repository;

import com.danamon.fundtransfer.fundtransferdanamonbe.entity.CustRel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustRelRepository extends JpaRepository<CustRel, UUID> {
}
