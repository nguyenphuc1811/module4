package com.codegym.furama.repository.contract;

import com.codegym.furama.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
    @Query(value = "select * from `attach_facility` af join `contract_detail` cd on af.id = cd.attach_facility_id join" +
            "`contract` c on c.id = cd.contract_id where c.id = :id", nativeQuery = true)
     List<AttachFacility> findAttachFacilityByContractId(@Param("id") int id);
}
