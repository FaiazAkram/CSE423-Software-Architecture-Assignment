package com.vetclinic.factory;

import com.vetclinic.dto.PetRequestDTO;
import com.vetclinic.dto.PetResponseDTO;
import com.vetclinic.model.Owner;
import com.vetclinic.model.Pet;
import com.vetclinic.model.PetType;

/**
 * Factory abstraction for {@link Pet}.
 * <p>
 * A Pet cannot be assembled from its request DTO alone — it references a
 * {@link PetType} and an {@link Owner}. Resolving those relationships (id
 * lookups, existence checks) is business logic and stays in the Service
 * layer; this factory only accepts the already-resolved entities and
 * performs pure object assembly.
 */
public interface PetFactory extends EntityFactory<Pet, PetResponseDTO> {

    /**
     * Builds a new, transient {@link Pet} entity from a request DTO plus the
     * already-resolved related entities.
     */
    Pet createFromRequest(PetRequestDTO dto, PetType type, Owner owner);

    /**
     * Applies the fields of a request DTO onto an existing entity, for updates.
     */
    void updateFromRequest(Pet entity, PetRequestDTO dto, PetType type, Owner owner);
}
