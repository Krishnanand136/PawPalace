package com.somanathdevs.pawpalace.service.impl;

import com.somanathdevs.pawpalace.dto.PetDTO;
import com.somanathdevs.pawpalace.entity.Pet;
import com.somanathdevs.pawpalace.mapper.Mapper;
import com.somanathdevs.pawpalace.repository.PetRepository;
import com.somanathdevs.pawpalace.service.PetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final Mapper mapper;

    public PetServiceImpl(PetRepository petRepository, Mapper mapper) {
        this.petRepository = petRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public PetDTO createPet(PetDTO petDTO) {
        Pet pet = mapper.convertPetDTOToEntity(petDTO);
        Pet saved = petRepository.save(pet);
        return mapper.convertPetEntityToDTO(saved);
    }
}
