package com.codegym.form_validate.model.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class UserDto implements Validator {

    private int id;
    @NotBlank(message = "Không đc để trống")
    @Size(min = 5, max = 45, message = "Giới hạn ký tự 5-45")
    private String firstName;
    @NotBlank(message = "Không đc để trống")
    @Size(min = 5, max = 45, message = "Giới hạn ký tự 5-45")
    private String lastName;
    @Pattern(regexp = "0[0-9]{9,11}", message = "Nhập sdt từ 10-12 số bắt đầu = 0")
    private String phoneNumber;
    private int age;
    @NotBlank(message = "Không đc để trống")
    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Sai định dạng email")
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        if (userDto.age < 18) {
            errors.rejectValue("age", "age", "Tuổi phải >= 18");
        }
    }
}
