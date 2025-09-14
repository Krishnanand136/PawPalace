package com.somanathdevs.pawpalace.service.impl;

import com.somanathdevs.pawpalace.constant.VaccinationStatus;
import com.somanathdevs.pawpalace.dto.VaccinationRecordDTO;
import com.somanathdevs.pawpalace.entity.VaccinationRecord;
import com.somanathdevs.pawpalace.mapper.Mapper;
import com.somanathdevs.pawpalace.repository.PetRepository;
import com.somanathdevs.pawpalace.repository.VaccinationRecordRepository;
import com.somanathdevs.pawpalace.service.VaccinationRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class VaccinationRecordServiceImpl implements VaccinationRecordService {

    private final VaccinationRecordRepository repository;
    private final Mapper mapper;

    private final PetRepository petRepository;

    public VaccinationRecordServiceImpl(VaccinationRecordRepository repository, Mapper mapper, PetRepository petRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.petRepository = petRepository;
    }

    @Override
    @Transactional
    public VaccinationRecordDTO createVaccinationRecord(VaccinationRecordDTO dto) {
        VaccinationRecord record = mapper.convertVaccinationRecordDTOToEntity(dto);
        validatePetExists(record.getPetId());
        record.setStatus(VaccinationStatus.SCHEDULED);
        VaccinationRecord saved = repository.save(record);
        System.out.println("\n\nvaccinate pet service execution completed successfully for pet Id : " + saved.getPetId());
        return mapper.convertVaccinationRecordEntityToDTO(saved);
    }


    @Override
    @Transactional
    public VaccinationRecordDTO fetchVaccinationRecordById(String vaccinationRecordId) {
        VaccinationRecord record = repository.findById(vaccinationRecordId)
                .orElseThrow(() -> new NoSuchElementException("Vaccination Record not found with id: " + vaccinationRecordId));
        System.out.println("\n\nFetch vaccination service execution completed successfully for vaccinationRecordId  : " + vaccinationRecordId);
        return mapper.convertVaccinationRecordEntityToDTO(record);
    }

    private void validatePetExists(String petId) {
        petRepository.findById(petId)
                .orElseThrow(() -> new NoSuchElementException("Pet not found with id: " + petId));
    }

}
