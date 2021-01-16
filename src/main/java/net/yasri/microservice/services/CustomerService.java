package net.yasri.microservice.services;

import net.yasri.microservice.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto newCustomerDto);

    void updateCustomerById(UUID customerId, CustomerDto customerDto);

    void deleteCustomerById(UUID customerId);
}
