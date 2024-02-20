package com.danamon.fundtransfer.fundtransferdanamonbe.repository;

import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Acct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AcctRepository extends JpaRepository<Acct, String> {
    @Query(value = "SELECT no_acct FROM danamon.tbl_acct WHERE no_acct = :no_acct", nativeQuery = true)
    String findSenderByNoAcct(String no_acct);

    @Query(value = "SELECT no_acct FROM danamon.tbl_acct WHERE no_acct = :no_acct and bank_flag = 1", nativeQuery = true)
    String findReceiverSameBankByNoAcct(String no_acct);

    @Query(value = "SELECT * FROM danamon.tbl_acct WHERE no_acct = :no_acct", nativeQuery = true)
    Optional<Acct> findAcctSenderByNoAcct(String no_acct);

    @Query(value = "SELECT * FROM danamon.tbl_acct WHERE no_acct = :no_acct and bank_flag = 1", nativeQuery = true)
    Optional<Acct> findReceiverByNoAcct(String no_acct);

    @Query(value = "SELECT balance FROM danamon.tbl_acct WHERE no_acct = :no_acct", nativeQuery = true)
    BigDecimal findBalanceByNoAcct(String no_acct);
}
