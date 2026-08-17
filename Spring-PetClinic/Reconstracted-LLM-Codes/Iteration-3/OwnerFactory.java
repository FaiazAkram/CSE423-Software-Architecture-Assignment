package com.vetclinic.factory;

import com.vetclinic.dto.OwnerRequestDTO;
import com.vetclinic.dto.OwnerResponseDTO;
import com.vetclinic.model.Owner;

/**
 * Factory abstraction for {@link Owner}.
 */
public interface OwnerFactory extends EntityFactory<Owner, OwnerResponseDTO> {

    /**
     * Builds a new, transient {@link Owner} entity from a request DTO.
     * The caller (Service layer) is responsible for persisting it.
     */
    Owner createFromRequest(OwnerRequestDTO dto);

    /**
     * Applies the fields of a request DTO onto an existing entity, for updates.
     */
    void updateFromRequest(Owner entity, OwnerRequestDTO dto);
}
