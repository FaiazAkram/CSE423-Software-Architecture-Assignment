package com.vetclinic.factory;

import com.vetclinic.dto.VetRequestDTO;
import com.vetclinic.dto.VetResponseDTO;
import com.vetclinic.model.Specialty;
import com.vetclinic.model.Vet;

import java.util.Set;

/**
 * Factory abstraction for {@link Vet}. Receives an already-resolved set of
 * {@link Specialty} entities from the Service layer.
 */
public interface VetFactory extends EntityFactory<Vet, VetResponseDTO> {

    /**
     * Builds a new, transient {@link Vet} entity from a request DTO plus the
     * already-resolved specialties.
     */
    Vet createFromRequest(VetRequestDTO dto, Set<Specialty> specialties);

    /**
     * Applies the fields of a request DTO onto an existing entity, for updates.
     */
    void updateFromRequest(Vet entity, VetRequestDTO dto, Set<Specialty> specialties);
}
