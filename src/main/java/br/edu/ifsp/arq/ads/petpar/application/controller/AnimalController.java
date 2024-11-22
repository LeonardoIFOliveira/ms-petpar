package br.edu.ifsp.arq.ads.petpar.application.controller;

import br.edu.ifsp.arq.ads.petpar.application.dto.AnimalDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import br.edu.ifsp.arq.ads.petpar.domain.service.AnimalService;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.AnimalMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/animal")
@RequiredArgsConstructor
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private AnimalMapper mapper;


    @Operation(description = "Lista Animais por status")
    @GetMapping("/list")
    public ResponseEntity<List<AnimalDto>> list(StatusAdoption statusAdoption, Integer pageNumber, Integer pageSize) throws Exception {
        var response = mapper.toDataTransferObjectList(
                animalService.listAnimalsByStatus(pageNumber, pageSize, List.of(statusAdoption)));

        return ResponseEntity.ok(response);
    }


    @Operation(description = "Lista animais da instituição")
    @GetMapping("/list-institution/{id}")
    public ResponseEntity<List<AnimalDto>> listByInstitutionId(String institutionId, Integer pageNumber, Integer pageSize) throws Exception {
        var response = mapper.toDataTransferObjectList(
                animalService.listAnimalsByInstitution(institutionId, pageNumber, pageSize));

        return ResponseEntity.ok(response);
    }


    @Operation(description = "Salva Animal na base de dados")
    @PostMapping
    public ResponseEntity save(AnimalDto request) throws Exception {

        animalService.save(mapper.toEntity(request));
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Seleciona animal por id")
    @GetMapping("/{id}")
    public ResponseEntity<AnimalDto> findById(Long id) throws Exception {
        var response = mapper.toDataTransferObject(animalService.findOrThrowNotFound(id));

        return ResponseEntity.ok(response);
    }

    @Operation(description = "Deleta animal na base de dados")
    @PutMapping
    public ResponseEntity delete(Long id) throws Exception {
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}