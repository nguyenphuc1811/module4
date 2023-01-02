package com.codegym.furama.repository.facility;

import com.codegym.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from facility where name like %:name% and facility_type_id = :facilityType", nativeQuery = true)
    Page<Facility> searchFacility(@Param("name") String name, @Param("facilityType") int facilityType, Pageable pageable);

    @Query(value = "select * from facility where name like %:name%", nativeQuery = true)
    Page<Facility> searchFacilityByName(@Param("name") String name, Pageable pageable);
}
