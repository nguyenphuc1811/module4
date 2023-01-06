package com.codegym.furama.service;

import com.codegym.furama.model.contract.Contract;


import java.util.List;

public interface IContractService  {
    List<Contract> fillAll();
    Contract findById(int id);
    void addContract(Contract contract);
    Double getTotal(int id);
}
