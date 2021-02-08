package net.yasri.microservice.web.controller;

import net.yasri.microservice.services.BreadService;
import net.yasri.microservice.web.model.BreadDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/bread")
@RestController
public class BreadController {

    private final BreadService breadService;

    public BreadController(BreadService breadService) {
        this.breadService = breadService;
    }

    @GetMapping({"/{breadId}"})
    public ResponseEntity<BreadDto> getBreadById(@PathVariable("breadId") UUID breadId) {
        return new ResponseEntity(breadService.getBreadById(breadId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBread(@RequestBody @Valid BreadDto newBread) {
        BreadDto savedDto = breadService.saveNewBread(newBread);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/bread/" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{breadId}"})
    public ResponseEntity updateBreadById(@PathVariable("breadId") UUID breadId, @RequestBody @Valid BreadDto breadDto) {
        breadService.updateBreadById(breadId, breadDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{breadId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBreadById(@PathVariable("breadId") UUID breadId) {

        breadService.deleteBreadById(breadId);
    }
}
