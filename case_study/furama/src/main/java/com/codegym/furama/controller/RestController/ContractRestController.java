package com.codegym.furama.controller.RestController;

import com.codegym.furama.model.contract.AttachFacility;
import com.codegym.furama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractRestController {

    @Autowired
    private IContractService ContractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("/view/{id}")
    public ResponseEntity<List<AttachFacility>> getAttachFacilityById(@PathVariable("id") int id) {
        List<AttachFacility> attachFacilities = attachFacilityService.findAttachFacilityByContractId(id);
        return new ResponseEntity<>(attachFacilities, HttpStatus.OK);
    }
}
