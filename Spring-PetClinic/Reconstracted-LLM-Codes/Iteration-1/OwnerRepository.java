package com.vetclinic.repository;

import com.vetclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findByLastNameContainingIgnoreCase(String lastName);
}
