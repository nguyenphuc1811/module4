package com.codegym.furama.repository.contract;

import com.codegym.furama.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
    @Query(value = "select af.* , sum(ifnull(quantity,0)) as quantity  from `attach_facility` af join `contract_detail` cd on af.id = cd.attach_facility_id join" +
            "`contract` c on c.id = cd.contract_id where c.id = :id group by af.id", nativeQuery = true)
    List<AttachFacility> findAttachFacilityByContractId(@Param("id") int id);

    @Query(value = "select sum(ifnull(quantity,0)) as quantity  from `attach_facility` af join `contract_detail` cd on af.id = cd.attach_facility_id join" +
            "`contract` c on c.id = cd.contract_id where c.id = :id and af.id = :afId group by af.id", nativeQuery = true)
    int getQuantity(@Param("id") int id, @Param("afId") int afId);

}
