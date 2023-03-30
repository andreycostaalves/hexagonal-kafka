package com.andreyalves.hexagonal.adapters.out.client.mapper;

import com.andreyalves.hexagonal.adapters.out.client.response.AddressResponse;
import com.andreyalves.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
