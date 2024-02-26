package com.danamon.fundtransfer.fundtransferdanamonbe.repository;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustGetDataResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustGetDataRepository extends JpaRepository<CustGetDataResponse, String> {
    @Transactional
    @Query(nativeQuery = true,value = "select * from danamon.get_data_cust('soyidwahyu')")
//    @Query(value = "select a.id,a.username,b.email,b.fullname,b.mobile_no,d.no_acct,a.atm_cif_no,a.visa_master_cif_no,cast(d.balance as varchar)" +
//            " from danamon.tbl_cust a" +
//            " inner join danamon.tbl_cust_profile b" +
//            " on b.cust_id = a.id" +
//            " inner join danamon.tbl_cust_rel c" +
//            " on c.cust_id = a.id" +
//            " inner join danamon.tbl_acct d" +
//            " on d.id = c.acct_id" +
//            " where a.username = :username", nativeQuery = true)
    CustGetDataResponse findGetCustGetData(@Param("username")String username);

    @Query(nativeQuery = true,value = "select * from danamon.get_data_cust(:username)")
    List<CustGetDataResponse> getData(@Param("username") String username);
}
