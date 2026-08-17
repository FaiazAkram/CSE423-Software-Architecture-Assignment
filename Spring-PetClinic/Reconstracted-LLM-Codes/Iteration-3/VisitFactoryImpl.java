package com.vetclinic.factory.impl;

import com.vetclinic.dto.VisitRequestDTO;
import com.vetclinic.dto.VisitResponseDTO;
import com.vetclinic.factory.VisitFactory;
import com.vetclinic.model.Pet;
import com.vetclinic.model.Vet;
import com.vetclinic.model.Visit;
import org.springframework.stereotype.Component;

/**
 * Concrete {@link VisitFactory}, managed by Spring as a singleton bean.
 */
@Component
public class VisitFactoryImpl implements VisitFactory {

    @Override
    public Visit createFromRequest(VisitRequestDTO dto, Pet pet, Vet vet) {
        if (dto == null) {
            return null;
        }
        return Visit.builder()
                .visitDate(dto.getVisitDate())
                .description(dto.getDescription())
                .pet(pet)
                .vet(vet)
                .build();
    }

    @Override
    public void updateFromRequest(Visit entity, VisitRequestDTO dto, Pet pet, Vet vet) {
        entity.setVisitDate(dto.getVisitDate());
        entity.setDescription(dto.getDescription());
        entity.setPet(pet);
        entity.setVet(vet);
    }

    @Override
    public VisitResponseDTO toResponseDTO(Visit entity) {
        if (entity == null) {
            return null;
        }
        Pet pet = entity.getPet();
        Vet vet = entity.getVet();
        return VisitResponseDTO.builder()
                .id(entity.getId())
                .visitDate(entity.getVisitDate())
                .description(entity.getDescription())
                .petId(pet != null ? pet.getId() : null)
                .petName(pet != null ? pet.getName() : null)
                .vetId(vet != null ? vet.getId() : null)
                .vetFullName(vet != null ? vet.getFirstName() + " " + vet.getLastName() : null)
                .build();
    }
}
