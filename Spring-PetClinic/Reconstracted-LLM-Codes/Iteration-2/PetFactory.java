package com.vetclinic.factory;

import com.vetclinic.dto.PetRequestDTO;
import com.vetclinic.dto.PetResponseDTO;
import com.vetclinic.model.Owner;
import com.vetclinic.model.Pet;
import com.vetclinic.model.PetType;
import org.springframework.stereotype.Component;

/**
 * Factory responsible for constructing Pet entities and DTOs.
 * Receives already-resolved related entities (PetType, Owner) from the
 * Service layer — it never performs repository lookups itself.
 */
@Component
public class PetFactory {

    private final PetTypeFactory petTypeFactory;

    public PetFactory(PetTypeFactory petTypeFactory) {
        this.petTypeFactory = petTypeFactory;
    }

    /**
     * Builds a new, transient Pet entity from a request DTO plus the
     * already-resolved PetType and Owner entities.
     */
    public Pet toEntity(PetRequestDTO dto, PetType petType, Owner owner) {
        if (dto == null) {
            return null;
        }
        return Pet.builder()
                .name(dto.getName())
                .birthDate(dto.getBirthDate())
                .type(petType)
                .owner(owner)
                .build();
    }

    /**
     * Applies the fields of a request DTO onto an existing entity, for updates.
     */
    public void updateEntity(Pet pet, PetRequestDTO dto, PetType petType, Owner owner) {
        pet.setName(dto.getName());
        pet.setBirthDate(dto.getBirthDate());
        pet.setType(petType);
        pet.setOwner(owner);
    }

    public PetResponseDTO toResponseDTO(Pet pet) {
        if (pet == null) {
            return null;
        }
        Owner owner = pet.getOwner();
        return PetResponseDTO.builder()
                .id(pet.getId())
                .name(pet.getName())
                .birthDate(pet.getBirthDate())
                .type(petTypeFactory.toDTO(pet.getType()))
                .ownerId(owner != null ? owner.getId() : null)
                .ownerFullName(owner != null ? owner.getFirstName() + " " + owner.getLastName() : null)
                .build();
    }
}
