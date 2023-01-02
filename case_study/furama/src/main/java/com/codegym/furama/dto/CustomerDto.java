package com.codegym.furama.dto;

import com.codegym.furama.model.customer.CustomerType;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDto {
    private int id;
    private CustomerType customerType;
    @Pattern(regexp = "[\\D]{5,45}", message = "Nhập tên đúng định dạng")
    private String name;
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Nhập đúng đinh dạng")
    private String dateOfBirth;
    private boolean gender;
    @Pattern(regexp = "[\\d]{9}", message = "Id Card quy định 9 số")
    private String idCard;
    @Pattern(regexp = "0[\\d]{9}", message = "Nhập số đúng định dạng 0*********")
    private String phoneNumber;
    @Pattern(regexp = "[\\w]+[@][\\w]+.[\\w]+", message = "Nhập đúng đinh dạng email")
    private String email;
    @Size(min = 5, max = 45, message = "Giới hạn ký tự 5-45")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
