package com.andreyalves.hexagonal.adapters.in.controller;

import com.andreyalves.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.andreyalves.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.andreyalves.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.andreyalves.hexagonal.application.core.domain.Customer;
import com.andreyalves.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.andreyalves.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.andreyalves.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.andreyalves.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;
    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    //inserção de Cliente
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update (@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest ){
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id){
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}
