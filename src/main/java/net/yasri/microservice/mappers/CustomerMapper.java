package net.yasri.microservice.mappers;

import net.yasri.microservice.domain.Customer;
import net.yasri.microservice.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
