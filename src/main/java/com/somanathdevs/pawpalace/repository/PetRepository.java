package com.somanathdevs.pawpalace.repository;

import com.somanathdevs.pawpalace.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, String> {
}