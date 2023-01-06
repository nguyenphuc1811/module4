package com.codegym.furama.dto.contract;

public interface IContractDto {
    int getId();

    int getFacilityId();

    int getEmployeeId();

    int getCustomerId();

    String getFacilityName();

    String getEmployeeName();

    String getCustomerName();

    String getStartDate();

    String getEndDate();

    Double getDeposit();

    Double getTotal();
}
