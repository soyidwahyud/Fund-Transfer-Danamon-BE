package com.danamon.fundtransfer.fundtransferdanamonbe.repository;

import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustRepository extends JpaRepository<Cust, UUID> {
    @Query(value = "SELECT * FROM danamon.tbl_cust ", nativeQuery = true)
    List<Cust> findAllCust();

    @Query(value = "SELECT * FROM danamon.tbl_cust WHERE username = :username", nativeQuery = true)
    List<Cust> findCustByUsername(@Param("username")String username);

    Optional<Cust> findByUsername(String username);

    Boolean existsByUsername(String username);
}
