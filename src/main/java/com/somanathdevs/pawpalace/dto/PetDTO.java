package com.somanathdevs.pawpalace.dto;

import com.somanathdevs.pawpalace.constant.PetType;
import com.somanathdevs.pawpalace.constant.Species;
import com.somanathdevs.pawpalace.constant.SubSpecies;
import lombok.Data;
import java.io.Serializable;

@Data
public class PetDTO implements Serializable {
    private String petId;
    private String name;
    private PetType type;
    private Species species;
    private SubSpecies subSpecies;
    private String breed;
    private Integer age;

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }
}
