package com.codegym.furama.service.impl;

import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.repository.contract.IContractRepository;
import com.codegym.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {

    @Autowired
    IContractRepository iContractRepository;

    public Page<Contract> fillAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    public Contract findById(int id) {
        return iContractRepository.getReferenceById(id);
    }

    public void addContract(Contract contract){
        iContractRepository.save(contract);
    }

}
