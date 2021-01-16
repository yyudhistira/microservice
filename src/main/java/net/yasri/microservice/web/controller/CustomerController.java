package net.yasri.microservice.web.controller;

import net.yasri.microservice.services.CustomerService;
import net.yasri.microservice.web.model.CustomerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public CustomerDto getCustomer(@PathVariable("customerId") UUID customerId) {
        return customerService.getCustomerById(customerId);
    }
}
