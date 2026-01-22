package com.somanathdevs.pawpalace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Trick {

    public Trick(String trickName) {
        this.trickName = trickName;
    }

    public Trick() {
        this.trickName = trickName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String trickId;

    private String trickName;

    private String command;

}
