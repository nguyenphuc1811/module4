package com.codegym.furama.model.customer;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private CustomerType customerType;
    @Column( nullable = false, columnDefinition = "varchar(45)")
    private String name;
    @Column(nullable = false, columnDefinition = "date")
    private String dateOfBirth;
    @Column(nullable = false)
    private boolean gender;
    @Column(unique = true,nullable = false,columnDefinition = "varchar(45)")
    private String idCard;
    @Column(unique = true,nullable = false, columnDefinition = "varchar(45)")
    private String phoneNumber;
    @Column(unique = true,columnDefinition = "varchar(45)")
    private String email;
    @Column(columnDefinition = "varchar(45)")
    private String address;

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

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
