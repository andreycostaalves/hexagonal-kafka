package com.andreyalves.hexagonal.application.ports.out;

import com.andreyalves.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutPutPort {

    void update(Customer customer);
}
