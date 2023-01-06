package com.codegym.furama.repository.contract;

import com.codegym.furama.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

}
