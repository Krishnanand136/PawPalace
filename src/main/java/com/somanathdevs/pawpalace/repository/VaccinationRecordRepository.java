package com.somanathdevs.pawpalace.repository;

import com.somanathdevs.pawpalace.entity.VaccinationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRecordRepository extends JpaRepository<VaccinationRecord, String> {
}