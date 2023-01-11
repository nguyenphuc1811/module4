package com.codegym.furama.dto.contract;

import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.model.facility.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class ContractDto implements Validator {

    private int id;
    private String startDate;
    private String endDate;
    private Double deposit;

    private Employee employee;

    private Customer customer;

    private Facility facility;

    private Double total;

    private Set<ContractDetail> contractDetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Set<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(Set<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if(contractDto.getDeposit() < 0){
            errors.rejectValue("deposit","deposit","Số tiền không được âm");
        }
        try {
            Date format = new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.endDate);
            Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.startDate);
            if (format2.compareTo(format) > 0) {
                errors.rejectValue("endDate", "endDate", "Ngày kết thúc > Ngày bắt đầu");
            }
        } catch (ParseException e) {
            errors.rejectValue("endDate", "endDate", "Không đúng định dạng");
            errors.rejectValue("startDate", "startDate", "Không đúng định dạng");
        }
    }
}
