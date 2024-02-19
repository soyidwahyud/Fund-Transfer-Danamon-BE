package com.danamon.fundtransfer.fundtransferdanamonbe.repository;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustGetDataResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Cust, String> {
    @Query(nativeQuery = true,value = "select * from danamon.get_data_cust(:username)")
    CustGetDataResponse findGetCustGetData(@Param("username")String username);
}
