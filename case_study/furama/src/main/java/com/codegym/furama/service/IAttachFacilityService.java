package com.codegym.furama.service;

import com.codegym.furama.model.contract.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAttachFacilityByContractId(int id);

    List<AttachFacility> findAll();

    int getQuantity(int id, int idAf);

    AttachFacility findById(int id);
}
