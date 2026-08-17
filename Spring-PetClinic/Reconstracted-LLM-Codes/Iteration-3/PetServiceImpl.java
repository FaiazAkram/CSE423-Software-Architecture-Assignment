package com.vetclinic.service.impl;

import com.vetclinic.dto.PetRequestDTO;
import com.vetclinic.dto.PetResponseDTO;
import com.vetclinic.exception.ResourceNotFoundException;
import com.vetclinic.factory.PetFactory;
import com.vetclinic.model.Owner;
import com.vetclinic.model.Pet;
import com.vetclinic.model.PetType;
import com.vetclinic.repository.PetRepository;
import com.vetclinic.repository.PetTypeRepository;
import com.vetclinic.service.OwnerService;
import com.vetclinic.service.PetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;
    private final OwnerService ownerService;
    private final PetFactory petFactory;

    public PetServiceImpl(PetRepository petRepository,
                           PetTypeRepository petTypeRepository,
                           OwnerService ownerService,
                           PetFactory petFactory) {
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
        this.ownerService = ownerService;
        this.petFactory = petFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PetResponseDTO> findAll() {
        return petRepository.findAll().stream()
                .map(petFactory::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PetResponseDTO findById(Long id) {
        return petFactory.toResponseDTO(getEntityById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PetResponseDTO> findByOwner(Long ownerId) {
        return petRepository.findByOwnerId(ownerId).stream()
                .map(petFactory::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PetResponseDTO create(PetRequestDTO dto) {
        PetType petType = getPetTypeById(dto.getPetTypeId());
        Owner owner = ownerService.getEntityById(dto.getOwnerId());
        Pet pet = petFactory.createFromRequest(dto, petType, owner);
        Pet saved = petRepository.save(pet);
        return petFactory.toResponseDTO(saved);
    }

    @Override
    public PetResponseDTO update(Long id, PetRequestDTO dto) {
        Pet existing = getEntityById(id);
        PetType petType = getPetTypeById(dto.getPetTypeId());
        Owner owner = ownerService.getEntityById(dto.getOwnerId());
        petFactory.updateFromRequest(existing, dto, petType, owner);
        return petFactory.toResponseDTO(petRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        Pet existing = getEntityById(id);
        petRepository.delete(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public Pet getEntityById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + id));
    }

    private PetType getPetTypeById(Long id) {
        return petTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet type not found with id: " + id));
    }
}
