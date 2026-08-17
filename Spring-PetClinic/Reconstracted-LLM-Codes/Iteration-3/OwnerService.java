package com.vetclinic.service;

import com.vetclinic.dto.OwnerRequestDTO;
import com.vetclinic.dto.OwnerResponseDTO;
import com.vetclinic.model.Owner;

import java.util.List;

public interface OwnerService {
    List<OwnerResponseDTO> findAll();
    OwnerResponseDTO findById(Long id);
    List<OwnerResponseDTO> searchByLastName(String lastName);
    OwnerResponseDTO create(OwnerRequestDTO dto);
    OwnerResponseDTO update(Long id, OwnerRequestDTO dto);
    void delete(Long id);

    /**
     * Fetches the raw Owner entity, for use by other services (e.g. PetService)
     * that need to resolve an owner relationship without going through DTOs.
     */
    Owner getEntityById(Long id);
}
