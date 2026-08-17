package com.vetclinic.factory;

import com.vetclinic.dto.VetRequestDTO;
import com.vetclinic.dto.VetResponseDTO;
import com.vetclinic.model.Specialty;
import com.vetclinic.model.Vet;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Factory responsible for constructing Vet entities and DTOs.
 * Receives already-resolved Specialty entities from the Service layer.
 */
@Component
public class VetFactory {

    private final SpecialtyFactory specialtyFactory;

    public VetFactory(SpecialtyFactory specialtyFactory) {
        this.specialtyFactory = specialtyFactory;
    }

    public Vet toEntity(VetRequestDTO dto, Set<Specialty> specialties) {
        if (dto == null) {
            return null;
        }
        return Vet.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .specialties(specialties != null ? specialties : Collections.emptySet())
                .build();
    }

    public void updateEntity(Vet vet, VetRequestDTO dto, Set<Specialty> specialties) {
        vet.setFirstName(dto.getFirstName());
        vet.setLastName(dto.getLastName());
        vet.setSpecialties(specialties != null ? specialties : Collections.emptySet());
    }

    public VetResponseDTO toResponseDTO(Vet vet) {
        if (vet == null) {
            return null;
        }
        Set<com.vetclinic.dto.SpecialtyDTO> specialtyDTOs = vet.getSpecialties() == null
                ? Collections.emptySet()
                : vet.getSpecialties().stream()
                    .map(specialtyFactory::toDTO)
                    .collect(Collectors.toSet());

        return VetResponseDTO.builder()
                .id(vet.getId())
                .firstName(vet.getFirstName())
                .lastName(vet.getLastName())
                .specialties(specialtyDTOs)
                .build();
    }
}
