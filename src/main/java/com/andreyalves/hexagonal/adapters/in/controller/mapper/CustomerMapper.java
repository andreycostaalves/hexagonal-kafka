package com.andreyalves.hexagonal.adapters.in.controller.mapper;

import com.andreyalves.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.andreyalves.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "string")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);
}
