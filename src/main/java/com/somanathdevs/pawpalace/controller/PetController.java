package com.somanathdevs.pawpalace.controller;

import com.somanathdevs.pawpalace.dto.PetDTO;
import com.somanathdevs.pawpalace.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<PetDTO> createPet(@RequestBody PetDTO petDTO) {
        PetDTO created = petService.createPet(petDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
