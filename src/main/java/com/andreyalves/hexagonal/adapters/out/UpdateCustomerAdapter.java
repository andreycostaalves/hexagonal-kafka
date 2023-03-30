package com.andreyalves.hexagonal.adapters.out;

import com.andreyalves.hexagonal.adapters.out.repository.CustomerRepository;
import com.andreyalves.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.andreyalves.hexagonal.application.core.domain.Customer;
import com.andreyalves.hexagonal.application.ports.out.UpdateCustomerOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var custumerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(custumerEntity);
    }
}
