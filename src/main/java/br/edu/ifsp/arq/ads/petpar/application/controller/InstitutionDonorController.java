package br.edu.ifsp.arq.ads.petpar.application.controller;

import br.edu.ifsp.arq.ads.petpar.application.dto.InstitutionDto;
import br.edu.ifsp.arq.ads.petpar.application.facade.InstitutionFacade;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/institution-donor")
@RequiredArgsConstructor
public class InstitutionDonorController{

    @Autowired
    private InstitutionFacade institutionFacade;

    //TODO
    //@PreAuthorize("hasAuthority('ROLE_SEARCH_USER') and hasAuthority('SCOPE_read')")
    @Operation(description = "Lista Animais por status")
    @GetMapping("/list")
    public ResponseEntity<List<InstitutionDto>> list(StatusAdoption statusAdoption, Integer pageNumber, Integer pageSize) throws Exception {
        var response = institutionFacade.list();
        return ResponseEntity.ok(response);
    }


    @Operation(description = "Loga instituição")
    @GetMapping("/login")
    public ResponseEntity listByInstitutionId(String email, String senha) throws Exception {
        institutionFacade.login(email,senha);
        return ResponseEntity.noContent().build();
    }


    @Operation(description="Salva instituição na base de dados")
    @PostMapping
    public ResponseEntity save(InstitutionDto request) throws Exception {
        institutionFacade.save(request);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Seleciona instituição por id")
    @GetMapping("/{id}")
    public ResponseEntity<InstitutionDto> findById(Long id) throws Exception {
        var response = institutionFacade.findOrThrowNotFound(id);

        return ResponseEntity.ok(response);
    }

    @Operation(description = "Deleta instituição na base de dados")
    @PutMapping
    public ResponseEntity delete(Long id) throws Exception {
        institutionFacade.delete(id);
        return ResponseEntity.noContent().build();
    }

}
