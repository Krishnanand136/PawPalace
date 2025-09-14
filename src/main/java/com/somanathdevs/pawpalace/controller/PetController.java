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
        System.out.println("Create pet controller execution started successfully for pet name : " +  petDTO);
        PetDTO created = petService.createPet(petDTO);
        System.out.println("Create pet controller execution completed successfully for pet id : " + petDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/petId/{petId}")
    public ResponseEntity<PetDTO> fetchPetById(@PathVariable String petId) {
        PetDTO pet = petService.fetchPetByPetId(petId);
        return ResponseEntity.ok(pet);
    }
}
