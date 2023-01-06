package com.codegym.furama.controller;

import com.codegym.furama.dto.contract.ContractDetailDto;
import com.codegym.furama.dto.contract.ContractDto;
import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

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

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("")
    public String showList(@PageableDefault(size = 5) Pageable pageable, Model model) {
        List<ContractDto> contractDtoList = new ArrayList<>();
        for (Contract contract :
                contractService.fillAll()) {
            ContractDto contractDto = new ContractDto();
            BeanUtils.copyProperties(contract, contractDto);
            contractDto.setTotal(contractService.getTotal(contractDto.getId()));
            contractDtoList.add(contractDto);
        }
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), contractDtoList.size());
        Page<ContractDto> dtoPage = new PageImpl<>(contractDtoList.subList(start, end), pageable, contractDtoList.size());
        model.addAttribute("contractList", dtoPage);
        model.addAttribute("customerList", customerService.findAllCustomer());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("facilityList", facilityService.getAll());
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        model.addAttribute("attachFacilityList", attachFacilityService.findAll());
        return "views/contract/listContract";
    }

    @PostMapping("/add")
    public String addContract(ContractDto contractDto, RedirectAttributes attributes) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.addContract(contract);
        return "redirect:/contract";
    }

    @PostMapping("/addContractDetail")
    public String addContractDetail(ContractDetailDto contractDetailDto) {
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        contractDetailService.addContractDetail(contractDetail);
        return "redirect:/contract";
    }

}
