package com.vetclinic.factory;

import com.vetclinic.dto.VisitRequestDTO;
import com.vetclinic.dto.VisitResponseDTO;
import com.vetclinic.model.Pet;
import com.vetclinic.model.Vet;
import com.vetclinic.model.Visit;

/**
 * Factory abstraction for {@link Visit}. Receives already-resolved
 * {@link Pet} and (optional) {@link Vet} entities from the Service layer.
 */
public interface VisitFactory extends EntityFactory<Visit, VisitResponseDTO> {

    /**
     * Builds a new, transient {@link Visit} entity from a request DTO plus
     * the already-resolved related entities.
     */
    Visit createFromRequest(VisitRequestDTO dto, Pet pet, Vet vet);

    /**
     * Applies the fields of a request DTO onto an existing entity, for updates.
     */
    void updateFromRequest(Visit entity, VisitRequestDTO dto, Pet pet, Vet vet);
}
