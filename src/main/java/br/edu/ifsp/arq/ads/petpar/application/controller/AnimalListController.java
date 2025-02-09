package br.edu.ifsp.arq.ads.petpar.application.controller;

import br.edu.ifsp.arq.ads.petpar.application.dto.AnimalDto;
import br.edu.ifsp.arq.ads.petpar.application.facade.AnimalFacade;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.SpecieType;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1/animal-list")
public class AnimalListController {

    @Autowired
    private AnimalFacade animalFacade;


    @GetMapping
    public ResponseEntity<List<AnimalDto>> list(@RequestParam SpecieType specie, @RequestParam Integer pageNumber, @RequestParam Integer pageSize) throws Exception {
        var response = animalFacade.listAnimalsByStatus(pageNumber, pageSize, List.of(specie));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{institutionId}")
    public ResponseEntity<List<AnimalDto>> listByInstitutionId(@PathVariable Long institutionId, @RequestParam Integer pageNumber, @RequestParam Integer pageSize) throws Exception {
        var response = animalFacade.listAnimalsByInstitution(institutionId, pageNumber, pageSize);
        return ResponseEntity.ok(response);
    }
}