package com.codegym.furama.service;


import com.codegym.furama.model.facility.Facility;
import com.codegym.furama.model.facility.FacilityType;
import com.codegym.furama.model.facility.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findAll(String name, String facilityType, Pageable pageable);

    List<FacilityType> facilityTypeList();

    List<RentType> rentTypeList();

    void deleteFacility(int id);

    boolean addFacility(Facility facility);

    void editFacility(Facility facility);

    Optional<Facility> findById(int id);
}
