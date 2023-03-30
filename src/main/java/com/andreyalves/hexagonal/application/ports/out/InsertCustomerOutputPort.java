package com.andreyalves.hexagonal.application.ports.out;

import com.andreyalves.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
