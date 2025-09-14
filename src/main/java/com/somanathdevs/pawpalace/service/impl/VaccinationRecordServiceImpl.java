package com.somanathdevs.pawpalace.service.impl;

import com.somanathdevs.pawpalace.constant.VaccinationStatus;
import com.somanathdevs.pawpalace.dto.VaccinationRecordDTO;
import com.somanathdevs.pawpalace.entity.VaccinationRecord;
import com.somanathdevs.pawpalace.mapper.Mapper;
import com.somanathdevs.pawpalace.repository.VaccinationRecordRepository;
import com.somanathdevs.pawpalace.service.PetService;
import com.somanathdevs.pawpalace.service.VaccinationRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class VaccinationRecordServiceImpl implements VaccinationRecordService {

    private final VaccinationRecordRepository repository;
    private final Mapper mapper;

    private final PetService petService;

    public VaccinationRecordServiceImpl(VaccinationRecordRepository repository, Mapper mapper, PetService petService) {
        this.repository = repository;
        this.mapper = mapper;
        this.petService = petService;
    }

    @Override
    @Transactional
    public VaccinationRecordDTO createVaccinationRecord(VaccinationRecordDTO dto) {
        VaccinationRecord record = mapper.convertVaccinationRecordDTOToEntity(dto);
        validatePetExists(record.getPetId());
        record.setStatus(VaccinationStatus.SCHEDULED);
        VaccinationRecord saved = repository.save(record);
        return mapper.convertVaccinationRecordEntityToDTO(saved);
    }


    @Override
    @Transactional
    public VaccinationRecordDTO fetchVaccinationRecordById(String vaccinationRecordId) {
        VaccinationRecord record = repository.findById(vaccinationRecordId)
                .orElseThrow(() -> new NoSuchElementException("Vaccination Record not found with id: " + vaccinationRecordId));
        return mapper.convertVaccinationRecordEntityToDTO(record);
    }

    private void validatePetExists(String petId) {
        petService.fetchPetByPetId(petId);
    }

}
