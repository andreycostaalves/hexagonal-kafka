package com.andreyalves.hexagonal.adapters.out.repository;

import com.andreyalves.hexagonal.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String > {
}
