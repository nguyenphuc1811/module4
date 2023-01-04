package com.codegym.furama.service;

import com.codegym.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService  {
    Page<Contract> fillAll(Pageable pageable);
    Contract findById(int id);
}
