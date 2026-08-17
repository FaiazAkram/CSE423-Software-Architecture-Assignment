package com.vetclinic.service.impl;

import com.vetclinic.dto.OwnerRequestDTO;
import com.vetclinic.dto.OwnerResponseDTO;
import com.vetclinic.exception.ResourceNotFoundException;
import com.vetclinic.factory.OwnerFactory;
import com.vetclinic.model.Owner;
import com.vetclinic.repository.OwnerRepository;
import com.vetclinic.service.OwnerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerFactory ownerFactory;

    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerFactory ownerFactory) {
        this.ownerRepository = ownerRepository;
        this.ownerFactory = ownerFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OwnerResponseDTO> findAll() {
        return ownerRepository.findAll().stream()
                .map(ownerFactory::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public OwnerResponseDTO findById(Long id) {
        return ownerFactory.toResponseDTO(getEntityById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OwnerResponseDTO> searchByLastName(String lastName) {
        return ownerRepository.findByLastNameContainingIgnoreCase(lastName).stream()
                .map(ownerFactory::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerResponseDTO create(OwnerRequestDTO dto) {
        Owner owner = ownerFactory.createFromRequest(dto);
        Owner saved = ownerRepository.save(owner);
        return ownerFactory.toResponseDTO(saved);
    }

    @Override
    public OwnerResponseDTO update(Long id, OwnerRequestDTO dto) {
        Owner existing = getEntityById(id);
        ownerFactory.updateFromRequest(existing, dto);
        return ownerFactory.toResponseDTO(ownerRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        Owner existing = getEntityById(id);
        ownerRepository.delete(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public Owner getEntityById(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with id: " + id));
    }
}
