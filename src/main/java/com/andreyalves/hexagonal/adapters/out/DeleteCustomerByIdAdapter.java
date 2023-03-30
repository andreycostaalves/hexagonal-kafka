package com.andreyalves.hexagonal.adapters.out;

import com.andreyalves.hexagonal.adapters.out.repository.CustomerRepository;
import com.andreyalves.hexagonal.application.ports.out.DeleteCustomerByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);

    }
}
