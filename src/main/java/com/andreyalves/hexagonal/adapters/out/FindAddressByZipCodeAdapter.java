package com.andreyalves.hexagonal.adapters.out;


import com.andreyalves.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.andreyalves.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.andreyalves.hexagonal.application.core.domain.Address;
import com.andreyalves.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutPutPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
