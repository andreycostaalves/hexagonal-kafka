package com.andreyalves.hexagonal.application.ports.in;

import com.andreyalves.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
