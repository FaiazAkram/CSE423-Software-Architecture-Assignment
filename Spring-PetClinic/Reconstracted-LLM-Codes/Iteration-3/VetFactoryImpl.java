package com.vetclinic.factory.impl;

import com.vetclinic.dto.SpecialtyDTO;
import com.vetclinic.dto.VetRequestDTO;
import com.vetclinic.dto.VetResponseDTO;
import com.vetclinic.factory.SpecialtyFactory;
import com.vetclinic.factory.VetFactory;
import com.vetclinic.model.Specialty;
import com.vetclinic.model.Vet;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Concrete {@link VetFactory}, managed by Spring as a singleton bean.
 * Depends on {@link SpecialtyFactory} (also a singleton) to build the
 * nested {@code SpecialtyDTO} set on the response.
 */
@Component
public class VetFactoryImpl implements VetFactory {

    private final SpecialtyFactory specialtyFactory;

    public VetFactoryImpl(SpecialtyFactory specialtyFactory) {
        this.specialtyFactory = specialtyFactory;
    }

    @Override
    public Vet createFromRequest(VetRequestDTO dto, Set<Specialty> specialties) {
        if (dto == null) {
            return null;
        }
        return Vet.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .specialties(specialties != null ? specialties : Collections.emptySet())
                .build();
    }

    @Override
    public void updateFromRequest(Vet entity, VetRequestDTO dto, Set<Specialty> specialties) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setSpecialties(specialties != null ? specialties : Collections.emptySet());
    }

    @Override
    public VetResponseDTO toResponseDTO(Vet entity) {
        if (entity == null) {
            return null;
        }
        Set<SpecialtyDTO> specialtyDTOs = entity.getSpecialties() == null
                ? Collections.emptySet()
                : entity.getSpecialties().stream()
                    .map(specialtyFactory::toResponseDTO)
                    .collect(Collectors.toSet());

        return VetResponseDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .specialties(specialtyDTOs)
                .build();
    }
}
