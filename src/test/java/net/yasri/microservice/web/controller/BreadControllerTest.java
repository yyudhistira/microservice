package net.yasri.microservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.yasri.microservice.services.BreadService;
import net.yasri.microservice.web.model.BreadDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BreadController.class)
class BreadControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BreadService breadService;

    @Test
    void getBreadById() throws Exception {
        mockMvc.perform(get("/api/v1/bread/" + UUID.randomUUID().toString())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    void saveNewBread() throws Exception {
        BreadDto breadDto = BreadDto.builder()
            .breadName("New bread")
            .build();
        String breadJson = objectMapper.writeValueAsString(breadDto);

        mockMvc.perform(post("/api/v1/bread/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(breadJson))
            .andExpect(status().isCreated());

    }

    @Test
    void updateBreadById() throws Exception {
        BreadDto breadDto = BreadDto.builder().build();
        String breadJson = objectMapper.writeValueAsString(breadDto);

        mockMvc.perform(put("/api/v1/bread/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(breadJson))
            .andExpect(status().isNoContent());
    }

    @Test
    void deleteBreadById() throws Exception {
        mockMvc.perform(delete("/api/v1/bread/" + UUID.randomUUID().toString()))
            .andExpect(status().isNoContent());
    }
}