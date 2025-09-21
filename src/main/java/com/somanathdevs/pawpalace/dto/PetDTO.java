package com.somanathdevs.pawpalace.dto;

import com.somanathdevs.pawpalace.constant.PetType;
import com.somanathdevs.pawpalace.constant.Species;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PetDTO implements Serializable {
    private String petId;
    private String name;
    private PetType type;
    private Species species;
    private String breed;
    private LocalDate dob;

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }
}
