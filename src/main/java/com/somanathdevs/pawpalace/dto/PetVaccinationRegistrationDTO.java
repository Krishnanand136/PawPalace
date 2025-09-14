package com.somanathdevs.pawpalace.dto;

public class PetVaccinationRegistrationDTO {
    private PetDTO pet;
    private VaccinationRecordDTO vaccinationRecord;

    public void setPet(PetDTO pet) {
        this.pet = pet;
    }

    public void setVaccinationRecord(VaccinationRecordDTO vaccinationRecord) {
        this.vaccinationRecord = vaccinationRecord;
    }

    public PetDTO getPet() {
        return pet;
    }

    public VaccinationRecordDTO getVaccinationRecord() {
        return vaccinationRecord;
    }
}
