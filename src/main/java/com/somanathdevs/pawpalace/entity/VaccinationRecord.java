package com.somanathdevs.pawpalace.entity;

import com.somanathdevs.pawpalace.constant.VaccinationStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class VaccinationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String vaccinationRecordId;

    private String petId;
    private String doctorId;
    private String vaccinationType;
    private LocalDate appointmentDate;

    @Enumerated(EnumType.STRING)
    private VaccinationStatus status;

    public String getPetId() {
        return petId;
    }

    public void setStatus(VaccinationStatus status) {
        this.status = status;
    }
}