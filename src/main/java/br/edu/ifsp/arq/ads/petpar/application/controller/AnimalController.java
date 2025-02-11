package br.edu.ifsp.arq.ads.petpar.application.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.ads.petpar.application.dto.AnimalDto;
import br.edu.ifsp.arq.ads.petpar.application.facade.AnimalFacade;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.SpecieType;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/animal")
public class AnimalController {

    @Autowired
    private AnimalFacade animalFacade;

//
//    @GetMapping("/list")
////    @PreAuthorize("hasAuthority('ROLE_REGISTER_USER') and hasAuthority('SCOPE_read')")
//    public ResponseEntity<List<AnimalDto>> list(@RequestBody SpecieType specie, @RequestParam Integer pageNumber, @RequestParam Integer pageSize) throws Exception {
//        var response = animalFacade.listAnimalsByStatus(pageNumber, pageSize, List.of(specie));
//
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/list-institution/{id}")
////    @PreAuthorize("hasAuthority('ROLE_REGISTER_INSTITUTION') and hasAuthority('SCOPE_read')")
//    public ResponseEntity<List<AnimalDto>> listByInstitutionId(@RequestParam String institutionId, @RequestParam Integer pageNumber, @RequestParam Integer pageSize) throws Exception {
//        var response = animalFacade.listAnimalsByInstitution(institutionId, pageNumber, pageSize);
//        return ResponseEntity.ok(response);
//    }

    @PostMapping
//    @PreAuthorize("hasAuthority('ROLE_REGISTER_INSTITUTION') and hasAuthority('SCOPE_write')")
    public ResponseEntity save(@RequestBody AnimalDto request) throws Exception {
        animalFacade.save(request);
        return ResponseEntity.noContent().build();
    }

//    @Operation(description = "Seleciona animal por id")
    @GetMapping("/{id}")
//    @PreAuthorize("hasRole('ROLE_SEARCH_USER') and hasAuthority('SCOPE_read')")
    public ResponseEntity<AnimalDto> findById( @PathVariable Long id) throws Exception {
        var response = animalFacade.findOrThrowNotFound(id);

        return ResponseEntity.ok(response);
    }

//    @Operation(description = "Deleta animal na base de dados")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        animalFacade.delete(id);
        return ResponseEntity.noContent().build();
    }

//    @Operation(description = "Retorna todos os animais disponíveis")
    @GetMapping("/all")
    public ResponseEntity<List<AnimalDto>> listAllAnimals() {
        var response = animalFacade.listAllAnimals();
        return ResponseEntity.ok(response);
    }

    //@Operation(description = "Filtrar animais disponíveis para adoção")
    @GetMapping("/filter")
    public ResponseEntity<List<AnimalDto>> filterAnimals(
            @RequestParam(required = false) String species,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        SpecieType specieEnum = null;
        if (species != null && !species.isEmpty()) {
            try {
                specieEnum = SpecieType.valueOf(species.toUpperCase()); // Converte string para enum
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(null); // Retorna erro se o valor for inválido
            }
        }

        List<AnimalDto> filteredAnimals = animalFacade.filterAnimals(specieEnum, startDate, endDate);
        return ResponseEntity.ok(filteredAnimals);
    }





}