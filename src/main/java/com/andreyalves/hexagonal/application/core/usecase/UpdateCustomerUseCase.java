package com.andreyalves.hexagonal.application.core.usecase;

import com.andreyalves.hexagonal.application.core.domain.Customer;
import com.andreyalves.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.andreyalves.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.andreyalves.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.andreyalves.hexagonal.application.ports.out.UpdateCustomerOutPutPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;

    private final UpdateCustomerOutPutPort updateCustomerOutPutPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort,
                                 UpdateCustomerOutPutPort updateCustomerOutPutPort){
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutPutPort;
        this.updateCustomerOutPutPort = updateCustomerOutPutPort;
    }

    @Override
    public void update(Customer customer, String zipCode){
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutPutPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutPutPort.update(customer);
    }
}
