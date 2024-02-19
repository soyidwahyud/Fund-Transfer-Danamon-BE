package com.danamon.fundtransfer.fundtransferdanamonbe.repository;

import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Acct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AcctRepository extends JpaRepository<Acct, String> {
    @Query(value = "SELECT no_acct FROM danamon.tbl_acct WHERE no_acct = :no_acct", nativeQuery = true)
    String findSenderByNoAcct(String no_acct);
}
