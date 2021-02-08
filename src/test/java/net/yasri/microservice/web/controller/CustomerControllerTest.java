package net.yasri.microservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.yasri.microservice.services.CustomerService;
import net.yasri.microservice.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CustomerService customerService;

    @Test
    void getCustomerById() throws Exception {
        mockMvc.perform(get("/api/v1/customer/" + UUID.randomUUID().toString())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    void saveNewCustomer() throws Exception {
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).build();
        String customerJson = objectMapper.writeValueAsString(customerDto);

        given(customerService.saveNewCustomer(any())).willReturn(customerDto);

        mockMvc.perform(post("/api/v1/customer")
            .contentType(MediaType.APPLICATION_JSON)
            .content(customerJson))
            .andExpect(status().isCreated());
    }

    @Test
    void updateCustomerById() throws Exception {
        CustomerDto customerDto = CustomerDto.builder().build();
        String customerJson = objectMapper.writeValueAsString(customerDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/customer/" + UUID.randomUUID().toString())
            .contentType(MediaType.APPLICATION_JSON)
            .content(customerJson))
            .andExpect(status().isNoContent());

    }

    @Test
    void deleteCustomerById() throws Exception {
        mockMvc.perform(delete("/api/v1/customer/" + UUID.randomUUID().toString()))
            .andExpect(status().isNoContent());
    }
}