package com.andreyalves.hexagonal.application.core.usecase;

import com.andreyalves.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.andreyalves.hexagonal.application.ports.out.DeleteCustomerByIdOutPutPort;

public class DeleteCustomerByIdUseCase {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOutPutPort deleteCustomerByIdOutPutPort;

    public DeleteCustomerByIdUseCase (FindCustomerByIdInputPort findCustomerByIdInputPort,
                                      DeleteCustomerByIdOutPutPort deleteCustomerByIdOutPutPort){
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutPutPort = deleteCustomerByIdOutPutPort;
    }

    public void delete(String id){
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutPutPort.delete(id);

    }


}
