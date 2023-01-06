package com.codegym.furama.controller.RestController;

import com.codegym.furama.dto.contract.AttachFacilityDto;
import com.codegym.furama.model.contract.AttachFacility;
import com.codegym.furama.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractRestController {

//    @Autowired
//    private IContractService ContractService;
//
//    @Autowired
//    private ICustomerService customerService;
//
//    @Autowired
//    private IEmployeeService employeeService;
//
//    @Autowired
//    private IFacilityService facilityService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("/view/{id}")
    public ResponseEntity<List<AttachFacilityDto>> getAttachFacilityById(@PathVariable("id") int id) {
        List<AttachFacility> attachFacilities = attachFacilityService.findAttachFacilityByContractId(id);
        List<AttachFacilityDto> attachFacilityDtos = new ArrayList<>();
        for (AttachFacility attachFacility : attachFacilities) {
            AttachFacilityDto attachFacilityDto = new AttachFacilityDto();
            BeanUtils.copyProperties(attachFacility, attachFacilityDto);
            attachFacilityDto.setQuantity(attachFacilityService.getQuantity(id, attachFacility.getId()));
            attachFacilityDtos.add(attachFacilityDto);
        }
        return new ResponseEntity<>(attachFacilityDtos, HttpStatus.OK);
    }
}
