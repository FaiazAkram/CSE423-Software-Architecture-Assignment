package com.vetclinic.factory;

import com.vetclinic.dto.OwnerRequestDTO;
import com.vetclinic.dto.OwnerResponseDTO;
import com.vetclinic.dto.PetSummaryDTO;
import com.vetclinic.model.Owner;
import com.vetclinic.model.Pet;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Factory responsible for constructing Owner entities and DTOs.
 * Pure object-assembly logic — no persistence, no validation rules,
 * no orchestration. Those responsibilities belong to the Service layer.
 */
@Component
public class OwnerFactory {

    /**
     * Builds a new, transient Owner entity from an incoming request DTO.
     * The caller (Service layer) is responsible for persisting it.
     */
    public Owner toEntity(OwnerRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return Owner.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .address(dto.getAddress())
                .city(dto.getCity())
                .telephone(dto.getTelephone())
                .build();
    }

    /**
     * Applies the fields of a request DTO onto an existing entity, for updates.
     */
    public void updateEntity(Owner owner, OwnerRequestDTO dto) {
        owner.setFirstName(dto.getFirstName());
        owner.setLastName(dto.getLastName());
        owner.setAddress(dto.getAddress());
        owner.setCity(dto.getCity());
        owner.setTelephone(dto.getTelephone());
    }

    public OwnerResponseDTO toResponseDTO(Owner owner) {
        if (owner == null) {
            return null;
        }
        List<PetSummaryDTO> petSummaries = owner.getPets() == null
                ? Collections.emptyList()
                : owner.getPets().stream()
                    .map(this::toPetSummaryDTO)
                    .collect(Collectors.toList());

        return OwnerResponseDTO.builder()
                .id(owner.getId())
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .address(owner.getAddress())
                .city(owner.getCity())
                .telephone(owner.getTelephone())
                .pets(petSummaries)
                .build();
    }

    private PetSummaryDTO toPetSummaryDTO(Pet pet) {
        return PetSummaryDTO.builder()
                .id(pet.getId())
                .name(pet.getName())
                .birthDate(pet.getBirthDate())
                .typeName(pet.getType() != null ? pet.getType().getName() : null)
                .build();
    }
}
