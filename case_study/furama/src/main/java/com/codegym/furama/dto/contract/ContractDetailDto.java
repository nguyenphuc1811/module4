package com.codegym.furama.dto.contract;

import com.codegym.furama.model.contract.AttachFacility;
import com.codegym.furama.model.contract.Contract;

public class ContractDetailDto {
    private int id;
    private Contract contract;
    private AttachFacility attachFacility;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
