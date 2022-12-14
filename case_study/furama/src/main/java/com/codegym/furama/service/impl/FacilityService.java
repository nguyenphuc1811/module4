package com.codegym.furama.service.impl;

import com.codegym.furama.model.facility.Facility;
import com.codegym.furama.model.facility.FacilityType;
import com.codegym.furama.model.facility.RentType;
import com.codegym.furama.repository.facility.IFacilityRepository;
import com.codegym.furama.repository.facility.IFacilityTypeRepository;
import com.codegym.furama.repository.facility.IRentTypeRepository;
import com.codegym.furama.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Autowired
    private IRentTypeRepository rentTypeRepository;

    public Page<Facility> findAll(String name, int facilityType, Pageable pageable) {
        return facilityRepository.searchFacility(name, facilityType, pageable);
    }

    public List<Facility> getAll() {
        return facilityRepository.findAll();
    }

    public List<FacilityType> facilityTypeList() {
        return facilityTypeRepository.findAll();
    }

    public List<RentType> rentTypeList() {
        return rentTypeRepository.findAll();
    }

    public void deleteFacility(int id) {
        facilityRepository.deleteById(id);
    }

    public boolean addFacility(Facility facility) {
        for (Facility f : facilityRepository.findAll()) {
            if (f.getName().equals(facility.getName())) {
                return false;
            }
        }
        facilityRepository.save(facility);
        return true;
    }

    public void editFacility(Facility facility) {
        facilityRepository.save(facility);
    }

    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }

    public Page<Facility> searchFacilityByName(String name, Pageable pageable) {
        return facilityRepository.searchFacilityByName(name, pageable);
    }
}
