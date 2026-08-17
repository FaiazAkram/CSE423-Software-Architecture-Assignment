package com.vetclinic.factory.impl;

import com.vetclinic.dto.PetRequestDTO;
import com.vetclinic.dto.PetResponseDTO;
import com.vetclinic.factory.PetFactory;
import com.vetclinic.factory.PetTypeFactory;
import com.vetclinic.model.Owner;
import com.vetclinic.model.Pet;
import com.vetclinic.model.PetType;
import org.springframework.stereotype.Component;

/**
 * Concrete {@link PetFactory}, managed by Spring as a singleton bean.
 * Depends on {@link PetTypeFactory} (also a singleton) to build the nested
 * {@code PetTypeDTO} on the response, keeping type-conversion logic in one
 * place rather than duplicating it here.
 */
@Component
public class PetFactoryImpl implements PetFactory {

    private final PetTypeFactory petTypeFactory;

    public PetFactoryImpl(PetTypeFactory petTypeFactory) {
        this.petTypeFactory = petTypeFactory;
    }

    @Override
    public Pet createFromRequest(PetRequestDTO dto, PetType type, Owner owner) {
        if (dto == null) {
            return null;
        }
        return Pet.builder()
                .name(dto.getName())
                .birthDate(dto.getBirthDate())
                .type(type)
                .owner(owner)
                .build();
    }

    @Override
    public void updateFromRequest(Pet entity, PetRequestDTO dto, PetType type, Owner owner) {
        entity.setName(dto.getName());
        entity.setBirthDate(dto.getBirthDate());
        entity.setType(type);
        entity.setOwner(owner);
    }

    @Override
    public PetResponseDTO toResponseDTO(Pet entity) {
        if (entity == null) {
            return null;
        }
        Owner owner = entity.getOwner();
        return PetResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .birthDate(entity.getBirthDate())
                .type(petTypeFactory.toResponseDTO(entity.getType()))
                .ownerId(owner != null ? owner.getId() : null)
                .ownerFullName(owner != null ? owner.getFirstName() + " " + owner.getLastName() : null)
                .build();
    }
}
