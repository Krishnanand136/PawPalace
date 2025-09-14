package com.somanathdevs.pawpalace.entity;

import com.somanathdevs.pawpalace.constant.Species;
import com.somanathdevs.pawpalace.constant.SubSpecies;
import jakarta.persistence.*;
import com.somanathdevs.pawpalace.constant.PetType;
import java.io.Serializable;

@Entity
public class Pet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PetType type;

    @Enumerated(EnumType.STRING)
    private Species species;

    @Enumerated(EnumType.STRING)
    private SubSpecies subSpecies;  // DOG, CAT, FISH

    private String breed;

    private Integer age;


}
