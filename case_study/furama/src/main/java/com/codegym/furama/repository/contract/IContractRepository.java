package com.codegym.furama.repository.contract;

import com.codegym.furama.dto.contract.IContractDto;
import com.codegym.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
//    @Query(value = "select (ifnull(f.cost, 0) + (sum(ifnull(af.cost, 0) * ifnull(cd.quantity, 0)))) as total from contract c left join facility f on f.id = c.facility_id left join contract_detail cd on c.id = cd.contract_id left join attach_facility af on af.id = cd.attach_facility_id group by c.id having c.id = :id", nativeQuery = true)
//    Double getTotal(@Param("id") int id);

    @Query(value = "select c.id , c.start_date as startDate, c.end_date as endDate , c.deposit, e.name as employeeName , ct.name as customerName , f.name as facilityName , (ifnull(f.cost, 0) + (sum(ifnull(af.cost, 0) * ifnull(cd.quantity, 0)))) as total from `contract` c left join `facility` f on f.id = c.facility_id left join `contract_detail` cd on c.id = cd.contract_id left join `attach_facility` af on af.id = cd.attach_facility_id join `customer` ct on c.customer_id = ct.id join `employee` e on e.id = c.employee_id group by c.id", nativeQuery = true)
    Page<IContractDto> findAllContract(Pageable pageable);
}
