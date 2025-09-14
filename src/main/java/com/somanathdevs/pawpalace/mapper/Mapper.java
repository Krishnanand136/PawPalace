package com.somanathdevs.pawpalace.mapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.somanathdevs.pawpalace.dto.PetDTO;
import com.somanathdevs.pawpalace.entity.Pet;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private final ObjectMapper objectMapper;

    public Mapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public PetDTO convertPetEntityToDTO(Pet pet) {
        return objectMapper.convertValue(pet, PetDTO.class);
    }

    public Pet convertPetDTOToEntity(PetDTO petDTO) {
        return objectMapper.convertValue(petDTO, Pet.class);
    }
}
