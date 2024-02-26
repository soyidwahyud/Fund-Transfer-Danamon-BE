package com.danamon.fundtransfer.fundtransferdanamonbe.repository;

import com.danamon.fundtransfer.fundtransferdanamonbe.entity.IntegrationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegrationLogRepository extends JpaRepository<IntegrationLog,String> {
}
