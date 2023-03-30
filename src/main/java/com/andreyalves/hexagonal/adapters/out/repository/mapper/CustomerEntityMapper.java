package com.andreyalves.hexagonal.adapters.out.repository.mapper;

import com.andreyalves.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.andreyalves.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCostomer(CustomerEntity customerEntity);

}
