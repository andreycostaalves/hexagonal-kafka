package com.andreyalves.hexagonal.application.ports.in;

import com.andreyalves.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find (String id);
}
