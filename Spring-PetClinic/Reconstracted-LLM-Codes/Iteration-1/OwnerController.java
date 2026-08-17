package com.vetclinic.controller;

import com.vetclinic.dto.OwnerRequestDTO;
import com.vetclinic.dto.OwnerResponseDTO;
import com.vetclinic.service.OwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping
    public List<OwnerResponseDTO> getAll(@RequestParam(required = false) String lastName) {
        if (lastName != null && !lastName.isBlank()) {
            return ownerService.searchByLastName(lastName);
        }
        return ownerService.findAll();
    }

    @GetMapping("/{id}")
    public OwnerResponseDTO getById(@PathVariable Long id) {
        return ownerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OwnerResponseDTO create(@Valid @RequestBody OwnerRequestDTO dto) {
        return ownerService.create(dto);
    }

    @PutMapping("/{id}")
    public OwnerResponseDTO update(@PathVariable Long id, @Valid @RequestBody OwnerRequestDTO dto) {
        return ownerService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        ownerService.delete(id);
    }
}
