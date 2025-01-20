package br.edu.ifsp.arq.ads.petpar.application.controller;

import br.edu.ifsp.arq.ads.petpar.application.facade.AdoptionFacade;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/adoption")
public class AdoptionController {

    @Autowired
    private AdoptionFacade adoptionFacade;

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_REGISTER_USER') and hasAuthority('SCOPE_write')")
    public ResponseEntity sendMessage(Long animalId, Long userId, StatusAdoption status) throws Exception {

        adoptionFacade.updateAdoptionStatus(userId, animalId, status);
        return ResponseEntity.noContent().build();
    }
}
