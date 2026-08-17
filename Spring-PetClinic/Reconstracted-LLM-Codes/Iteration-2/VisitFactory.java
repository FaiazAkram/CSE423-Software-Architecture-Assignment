package com.vetclinic.factory;

import com.vetclinic.dto.VisitRequestDTO;
import com.vetclinic.dto.VisitResponseDTO;
import com.vetclinic.model.Pet;
import com.vetclinic.model.Vet;
import com.vetclinic.model.Visit;
import org.springframework.stereotype.Component;

/**
 * Factory responsible for constructing Visit entities and DTOs.
 * Receives already-resolved related entities (Pet, Vet) from the
 * Service layer — it never performs repository lookups itself.
 */
@Component
public class VisitFactory {

    public Visit toEntity(VisitRequestDTO dto, Pet pet, Vet vet) {
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

    public void updateEntity(Visit visit, VisitRequestDTO dto, Pet pet, Vet vet) {
        visit.setVisitDate(dto.getVisitDate());
        visit.setDescription(dto.getDescription());
        visit.setPet(pet);
        visit.setVet(vet);
    }

    public VisitResponseDTO toResponseDTO(Visit visit) {
        if (visit == null) {
            return null;
        }
        Pet pet = visit.getPet();
        Vet vet = visit.getVet();
        return VisitResponseDTO.builder()
                .id(visit.getId())
                .visitDate(visit.getVisitDate())
                .description(visit.getDescription())
                .petId(pet != null ? pet.getId() : null)
                .petName(pet != null ? pet.getName() : null)
                .vetId(vet != null ? vet.getId() : null)
                .vetFullName(vet != null ? vet.getFirstName() + " " + vet.getLastName() : null)
                .build();
    }
}
