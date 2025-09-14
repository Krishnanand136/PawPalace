package com.somanathdevs.pawpalace.service;

import com.somanathdevs.pawpalace.dto.PetDTO;

public interface PetService {

    PetDTO createPet(PetDTO petDTO);
    PetDTO fetchPetById(String id);

}