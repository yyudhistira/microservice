package net.yasri.microservice.web.controller;

import net.yasri.microservice.services.BreadService;
import net.yasri.microservice.web.model.BreadDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/bread")
@RestController
public class BreadController {

    private final BreadService breadService;

    public BreadController(BreadService breadService) {
        this.breadService = breadService;
    }

    @GetMapping({"/{breadId}"})
    public ResponseEntity<BreadDto> getBread(@PathVariable("breadId") UUID breadId) {
        return new ResponseEntity(breadService.getBreadById(breadId), HttpStatus.OK);
    }
}
