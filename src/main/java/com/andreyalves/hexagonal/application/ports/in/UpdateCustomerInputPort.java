package com.andreyalves.hexagonal.application.ports.in;

import com.andreyalves.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
