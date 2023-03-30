package com.andreyalves.hexagonal.application.core.usecase;

import com.andreyalves.hexagonal.application.core.domain.Customer;
import com.andreyalves.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.andreyalves.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.andreyalves.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.andreyalves.hexagonal.application.ports.out.SendCpfForValidationOutPutPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    //portas de saida.
    private final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutPutPort sendCpfForValidationOutPutPort;

    //instanciando - construtor das portas de saida.
    public InsertCustomerUseCase( FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort,
                                  InsertCustomerOutputPort insertCustomerOutputPort,
                                  SendCpfForValidationOutPutPort sendCpfForValidationOutPutPort){
        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutPutPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutPutPort = sendCpfForValidationOutPutPort;
    }

    //metodo insert
    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutPutPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutPutPort.send(customer.getCpf());
    }
}
