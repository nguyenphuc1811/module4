package com.codegym.furama.model.employee;

import com.codegym.furama.model.employee.user_role.User;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false,columnDefinition = "varchar(45)")
    private String name;
    @Column(nullable = false,columnDefinition = "date")
    private String dateOfBirth;
    @Column(nullable = false,columnDefinition = "varchar(45)")
    private String idCard;
    @Column(nullable = false,columnDefinition = "varchar(45)")
    private double salary;
    @Column(nullable = false,columnDefinition = "varchar(45)")
    private String phoneNumber;
    @Column(columnDefinition = "varchar(45)")
    private String email;
    @ManyToOne
    private Position position;
    @ManyToOne
    private EducationDegree educationDegree;
    @ManyToOne
    private Division division;
    @OneToOne
    @JoinColumn(name = "username",referencedColumnName = "username")
    private User user;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
