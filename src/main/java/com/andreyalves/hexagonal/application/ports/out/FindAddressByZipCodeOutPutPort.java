package com.andreyalves.hexagonal.application.ports.out;

import com.andreyalves.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutPutPort {

    Address find(String zipCode);
}
