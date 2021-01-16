package net.yasri.microservice.services;

import net.yasri.microservice.web.model.BreadDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BreadServiceImpl implements BreadService {
    @Override
    public BreadDto getBreadById(UUID breadId) {
        return BreadDto.builder()
            .id(UUID.randomUUID())
            .breadName("Galaxy Car")
            .bredStyle("White Bread")
            .build();
    }
}
