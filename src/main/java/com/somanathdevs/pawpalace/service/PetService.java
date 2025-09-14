package com.somanathdevs.pawpalace.service;

import com.somanathdevs.pawpalace.dto.PetDTO;
import com.somanathdevs.pawpalace.dto.PetVaccinationRegistrationDTO;

public interface PetService {

    PetDTO createPet(PetDTO petDTO);
    PetDTO fetchPetByPetId(String petId);

    PetVaccinationRegistrationDTO registerAndVaccinatePet(PetVaccinationRegistrationDTO requestDTO);

}