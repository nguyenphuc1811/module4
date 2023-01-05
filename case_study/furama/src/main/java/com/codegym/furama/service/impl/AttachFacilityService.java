package com.codegym.furama.service.impl;

import com.codegym.furama.model.contract.AttachFacility;
import com.codegym.furama.repository.contract.IAttachFacilityRepository;
import com.codegym.furama.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    public List<AttachFacility> findAttachFacilityByContractId(int id) {
       return attachFacilityRepository.findAttachFacilityByContractId(id);
    }
}
