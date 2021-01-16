package net.yasri.microservice.services;

import lombok.extern.slf4j.Slf4j;
import net.yasri.microservice.web.model.BreadDto;
import net.yasri.microservice.web.model.BreadStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BreadServiceImpl implements BreadService {
    @Override
    public BreadDto getBreadById(UUID breadId) {
        return BreadDto.builder()
            .id(UUID.randomUUID())
            .breadName("Galaxy Car")
            .bredStyle(BreadStyleEnum.BLAND)
            .build();
    }

    @Override
    public BreadDto saveNewBread(BreadDto newBread) {
        return BreadDto.builder()
            .id(UUID.randomUUID())
            .breadName(newBread.getBreadName())
            .bredStyle(newBread.getBredStyle())
            .upc(newBread.getUpc())
            .build();
    }

    @Override
    public void updateBreadById(UUID breadId, BreadDto breadDto) {
        // TODO: implementation
    }

    @Override
    public void deleteBreadById(UUID breadId) {
        log.debug("Bread deleted ....");
    }

}
