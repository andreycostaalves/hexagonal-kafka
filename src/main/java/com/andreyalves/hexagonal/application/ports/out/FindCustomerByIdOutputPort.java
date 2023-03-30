package com.andreyalves.hexagonal.application.ports.out;

import com.andreyalves.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find (String id);
}
