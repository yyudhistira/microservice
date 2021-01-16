package net.yasri.microservice.services;

import lombok.extern.slf4j.Slf4j;
import net.yasri.microservice.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
            .id(UUID.randomUUID())
            .name("Mr Smith")
            .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto newCustomerDto) {
        return CustomerDto.builder()
            .id(UUID.randomUUID())
            .name(newCustomerDto.getName())
            .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        // TODO: implementation
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Customer deleted ...");
    }
}
