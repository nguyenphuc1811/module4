package com.codegym.furama.controller;

import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contract")
public class ContractController<Set> {

    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("")
    public String showList(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("contractList", contractService.fillAll(pageable));
        model.addAttribute("customerList", customerService.findAllCustomer());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("facilityList", facilityService.getAll());
        model.addAttribute("contract", new Contract());
        return "views/contract/listContract";
    }

    @ResponseBody
    @GetMapping("/showAttach/{id}")
    public Contract contractDetailSet(@PathVariable("id") int id, Model model) {
        return contractService.findById(id);
    }

}
