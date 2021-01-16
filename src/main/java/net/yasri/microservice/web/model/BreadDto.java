package net.yasri.microservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BreadDto {
    private UUID id;
    private String breadName;
    private String bredStyle;
    private Long upc;
}
