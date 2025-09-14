package com.somanathdevs.pawpalace.service.impl;

import com.somanathdevs.pawpalace.dto.PetDTO;
import com.somanathdevs.pawpalace.entity.Pet;
import com.somanathdevs.pawpalace.event.TransactionalEvent;
import com.somanathdevs.pawpalace.mapper.Mapper;
import com.somanathdevs.pawpalace.repository.PetRepository;
import com.somanathdevs.pawpalace.service.PetService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class PetServiceImpl implements PetService {

    @PersistenceContext
    private EntityManager entityManager;
    private final PetRepository petRepository;
    private final Mapper mapper;
    private final ApplicationEventPublisher applicationEventPublisher;

    public PetServiceImpl(PetRepository petRepository, Mapper mapper, ApplicationEventPublisher applicationEventPublisher) {
        this.petRepository = petRepository;
        this.mapper = mapper;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    @Transactional
    public PetDTO createPet(PetDTO petDTO) {
        Pet pet = mapper.convertPetDTOToEntity(petDTO);
        Pet saved = petRepository.save(pet);
        System.out.println("Pet Repository save method is called for pet Id : " + saved);
        applicationEventPublisher.publishEvent(new TransactionalEvent(saved));
        System.out.println("Create pet service execution completed successfully for pet Id : " + saved);
        return mapper.convertPetEntityToDTO(saved);
    }

    @Transactional
    @Override
    public PetDTO fetchPetByPetId(String id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pet not found with id: " + id));
        return mapper.convertPetEntityToDTO(pet);
    }

}
