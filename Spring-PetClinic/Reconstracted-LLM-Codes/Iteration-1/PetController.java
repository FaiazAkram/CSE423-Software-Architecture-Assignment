package com.vetclinic.controller;

import com.vetclinic.dto.PetRequestDTO;
import com.vetclinic.dto.PetResponseDTO;
import com.vetclinic.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping
    public List<PetResponseDTO> getAll(@RequestParam(required = false) Long ownerId) {
        if (ownerId != null) {
            return petService.findByOwner(ownerId);
        }
        return petService.findAll();
    }

    @GetMapping("/{id}")
    public PetResponseDTO getById(@PathVariable Long id) {
        return petService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetResponseDTO create(@Valid @RequestBody PetRequestDTO dto) {
        return petService.create(dto);
    }

    @PutMapping("/{id}")
    public PetResponseDTO update(@PathVariable Long id, @Valid @RequestBody PetRequestDTO dto) {
        return petService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        petService.delete(id);
    }
}
