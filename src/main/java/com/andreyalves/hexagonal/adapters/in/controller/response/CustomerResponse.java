package com.andreyalves.hexagonal.adapters.in.controller.response;

import com.andreyalves.hexagonal.application.core.domain.Address;
import lombok.Data;

@Data
public class CustomerResponse {

    private String name;
    private AddressResponse address;
    private String cpf;
    private Boolean isValidCpf;
}
