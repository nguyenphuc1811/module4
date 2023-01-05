package com.codegym.furama.service.impl;

import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.repository.contract.IContractDetailRepository;
import com.codegym.furama.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    public void addContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
