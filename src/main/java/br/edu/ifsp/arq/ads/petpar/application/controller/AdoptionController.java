package br.edu.ifsp.arq.ads.petpar.application.controller;

import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import br.edu.ifsp.arq.ads.petpar.domain.service.AdoptionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/adoption")
@RequiredArgsConstructor
public class AdoptionController {

    @Autowired
    private AdoptionService adoptionService;
    @Operation(description = "Solicitação e atualização do status adoção do animal")
    @PutMapping
    public ResponseEntity sendMessage(Long animalId, Long userId, StatusAdoption status) throws Exception {

        adoptionService.updateAdoptionStatus(userId, animalId, status);
        return ResponseEntity.noContent().build();
    }
}
