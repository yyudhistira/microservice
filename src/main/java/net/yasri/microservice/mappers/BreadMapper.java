package net.yasri.microservice.mappers;

import net.yasri.microservice.domain.Bread;
import net.yasri.microservice.web.model.BreadDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BreadMapper {
    BreadDto breadToBreadDto(Bread bread);
    Bread breadDtoToBread(BreadDto breadDto);
}
