package com.somanathdevs.pawpalace.service;

import com.somanathdevs.pawpalace.dto.VaccinationRecordDTO;

public interface VaccinationRecordService {
    VaccinationRecordDTO createVaccinationRecord(VaccinationRecordDTO dto);
    VaccinationRecordDTO fetchVaccinationRecordById(String vaccinationRecordId);

}
