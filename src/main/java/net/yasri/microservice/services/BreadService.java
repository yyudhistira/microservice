package net.yasri.microservice.services;

import net.yasri.microservice.web.model.BreadDto;

import java.util.UUID;

public interface BreadService {
    BreadDto getBreadById(UUID breadId);

    BreadDto saveNewBread(BreadDto newBread);

    void updateBreadById(UUID breadId, BreadDto breadDto);

    void deleteBreadById(UUID breadId);
}
