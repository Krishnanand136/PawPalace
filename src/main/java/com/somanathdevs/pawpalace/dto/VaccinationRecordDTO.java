package com.somanathdevs.pawpalace.dto;

import com.somanathdevs.pawpalace.constant.VaccinationType;
import lombok.Data;
import java.time.LocalDate;

@Data
public class VaccinationRecordDTO {
    private String vaccinationRecordId;              // auto-generated
    private String petId;           // must exist
    private String doctorId;        // vet assigned
    private VaccinationType vaccinationType; // e.g., Rabies
    private LocalDate appointmentDate;
    private String status;
}
