package net.yasri.microservice.services;

import net.yasri.microservice.web.model.BreadDto;

import java.util.UUID;

public interface BreadService {
    BreadDto getBreadById(UUID breadId);
}
