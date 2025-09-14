package com.somanathdevs.pawpalace.service.impl;

import com.somanathdevs.pawpalace.dto.PetDTO;
import com.somanathdevs.pawpalace.dto.PetVaccinationRegistrationDTO;
import com.somanathdevs.pawpalace.dto.VaccinationRecordDTO;
import com.somanathdevs.pawpalace.entity.Pet;
import com.somanathdevs.pawpalace.mapper.Mapper;
import com.somanathdevs.pawpalace.repository.PetRepository;
import com.somanathdevs.pawpalace.service.PetService;
import com.somanathdevs.pawpalace.service.VaccinationRecordService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class PetServiceImpl implements PetService {

    @PersistenceContext
    private EntityManager entityManager;
    private final PetRepository petRepository;
    private final Mapper mapper;
    private final VaccinationRecordService vaccinationRecordService;

    public PetServiceImpl(PetRepository petRepository,
                          Mapper mapper,
                          VaccinationRecordService vaccinationRecordService
    ) {
        this.petRepository = petRepository;
        this.mapper = mapper;
        this.vaccinationRecordService = vaccinationRecordService;
    }

    @Override
    @Transactional
    public PetDTO createPet(PetDTO petDTO) {
        Pet pet = mapper.convertPetDTOToEntity(petDTO);
        Pet saved = petRepository.save(pet);
        System.out.println("\n\nCreate pet service execution completed successfully for pet Id : " + saved.getPetId());
        return mapper.convertPetEntityToDTO(saved);
    }

    @Transactional
    @Override
    public PetDTO fetchPetByPetId(String id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pet not found with id: " + id));
        System.out.println("\n\nFetch pet service execution completed successfully for pet Id : " + pet.getPetId());
        return mapper.convertPetEntityToDTO(pet);
    }

    @Override
    @Transactional
    public PetVaccinationRegistrationDTO registerAndVaccinatePet(PetVaccinationRegistrationDTO petVaccinationRegistrationDTO) {
        PetDTO petDTO = createPet(petVaccinationRegistrationDTO.getPet());
        VaccinationRecordDTO vaccinationRecord = petVaccinationRegistrationDTO.getVaccinationRecord();
        vaccinationRecord.setPetId(petDTO.getPetId());
        VaccinationRecordDTO savedVaccinationRecord = vaccinationRecordService.createVaccinationRecord(vaccinationRecord);
        petVaccinationRegistrationDTO.setPet(petDTO);
        petVaccinationRegistrationDTO.setVaccinationRecord(savedVaccinationRecord);
        System.out.println("\n\nRegister pet and vaccinate service execution completed successfully for pet Id : " + petDTO.getPetId());
        return petVaccinationRegistrationDTO;
    }

}
