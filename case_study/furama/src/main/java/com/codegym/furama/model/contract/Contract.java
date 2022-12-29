package com.codegym.furama.model.contract;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, columnDefinition = "date")
    private String startDate;
    @Column(nullable = false, columnDefinition = "date")
    private String endDate;
    @Column(nullable = false)
    private Double deposit;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private com.codegym.furama.model.facility.Facility facility;
    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetails;

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Contract() {
    }

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

    public com.codegym.furama.model.facility.Facility getFacility() {
        return facility;
    }

    public void setFacility(com.codegym.furama.model.facility.Facility facility) {
        this.facility = facility;
    }

}
