package com.somanathdevs.pawpalace.entity;

import com.somanathdevs.pawpalace.constant.PetType;
import com.somanathdevs.pawpalace.constant.Species;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Pet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String petId;

    private String name;

    @Enumerated(EnumType.STRING)
    private PetType type;

    @Enumerated(EnumType.STRING)
    private Species species;

    private String breed;

    private LocalDate dob;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Trick> tricks;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPetId() {
        return petId;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId='" + petId + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", species=" + species +
                ", breed='" + breed + '\'' +
                ", dob=" + dob +
                '}';
    }
}
