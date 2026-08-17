package com.vetclinic.factory.impl;

import com.vetclinic.dto.OwnerRequestDTO;
import com.vetclinic.dto.OwnerResponseDTO;
import com.vetclinic.dto.PetSummaryDTO;
import com.vetclinic.factory.OwnerFactory;
import com.vetclinic.model.Owner;
import com.vetclinic.model.Pet;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Concrete {@link OwnerFactory}, managed by Spring as a singleton bean.
 */
@Component
public class OwnerFactoryImpl implements OwnerFactory {

    @Override
    public Owner createFromRequest(OwnerRequestDTO dto) {
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

    @Override
    public void updateFromRequest(Owner entity, OwnerRequestDTO dto) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setTelephone(dto.getTelephone());
    }

    @Override
    public OwnerResponseDTO toResponseDTO(Owner entity) {
        if (entity == null) {
            return null;
        }
        List<PetSummaryDTO> petSummaries = entity.getPets() == null
                ? Collections.emptyList()
                : entity.getPets().stream()
                    .map(this::toPetSummaryDTO)
                    .collect(Collectors.toList());

        return OwnerResponseDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .address(entity.getAddress())
                .city(entity.getCity())
                .telephone(entity.getTelephone())
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
