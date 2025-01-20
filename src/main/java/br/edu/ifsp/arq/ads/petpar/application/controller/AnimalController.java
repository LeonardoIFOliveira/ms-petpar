package br.edu.ifsp.arq.ads.petpar.application.controller;

import br.edu.ifsp.arq.ads.petpar.application.dto.AnimalDto;
import br.edu.ifsp.arq.ads.petpar.application.facade.AnimalFacade;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/animal")
public class AnimalController {

    @Autowired
    private AnimalFacade animalFacade;


    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ROLE_REGISTER_USER') and hasAuthority('SCOPE_read')")
    public ResponseEntity<List<AnimalDto>> list(StatusAdoption statusAdoption, Integer pageNumber, Integer pageSize) throws Exception {
        var response = animalFacade.listAnimalsByStatus(pageNumber, pageSize, List.of(statusAdoption));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/list-institution/{id}")
    @PreAuthorize("hasAuthority('ROLE_REGISTER_INSTITUTION') and hasAuthority('SCOPE_read')")
    public ResponseEntity<List<AnimalDto>> listByInstitutionId(String institutionId, Integer pageNumber, Integer pageSize) throws Exception {
        var response = animalFacade.listAnimalsByInstitution(institutionId, pageNumber, pageSize);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_REGISTER_INSTITUTION') and hasAuthority('SCOPE_write')")
    public ResponseEntity save(AnimalDto request) throws Exception {
        animalFacade.save(request);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Seleciona animal por id")
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SEARCH_USER') and hasAuthority('SCOPE_read')")
    public ResponseEntity<AnimalDto> findById(Long id) throws Exception {
        var response = animalFacade.findOrThrowNotFound(id);

        return ResponseEntity.ok(response);
    }

    @Operation(description = "Deleta animal na base de dados")
    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_REMOVE_INSTITUTION') and hasAuthority('SCOPE_write')")
    public ResponseEntity delete(Long id) throws Exception {
        animalFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}