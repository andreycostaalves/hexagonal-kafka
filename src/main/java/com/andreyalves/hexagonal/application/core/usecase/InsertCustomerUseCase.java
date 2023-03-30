package com.andreyalves.hexagonal.application.core.usecase;

import com.andreyalves.hexagonal.application.core.domain.Customer;
import com.andreyalves.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.andreyalves.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.andreyalves.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    //portas de saida.
    private final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    //instanciando - construtor das portas de saida.
    public InsertCustomerUseCase( FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort,
                                  InsertCustomerOutputPort insertCustomerOutputPort){
        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutPutPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    //metodo insert
    @Override
    public void insert(Customer custumer, String zipCode){
        var address = findAddressByZipCodeOutPutPort.find(zipCode);
        custumer.setAddress(address);
        insertCustomerOutputPort.insert(custumer);
    }
}
