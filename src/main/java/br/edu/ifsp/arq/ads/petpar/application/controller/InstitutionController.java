package br.edu.ifsp.arq.ads.petpar.application.controller;

import br.edu.ifsp.arq.ads.petpar.application.dto.InstitutionDto;
import br.edu.ifsp.arq.ads.petpar.application.facade.InstitutionFacade;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/institution")
public class InstitutionController {

    @Autowired
    private InstitutionFacade institutionFacade;

    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_SEARCH_INSTITUTION') and hasAuthority('SCOPE_read')")
    public ResponseEntity<List<InstitutionDto>> list( @RequestParam StatusAdoption statusAdoption,
                                                      @RequestParam Integer pageNumber,
                                                      @RequestParam Integer pageSize) throws Exception {
        var response = institutionFacade.list();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/login")
    @PreAuthorize("hasRole('ROLE_SEARCH_INSTITUTION') and hasAuthority('SCOPE_read')")
    public ResponseEntity listByInstitutionId( @RequestParam String email, @RequestParam String senha) throws Exception {
        institutionFacade.login(email,senha);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    //@PreAuthorize("hasAuthority('ROLE_REGISTER_INSTITUTION') and hasAuthority('SCOPE_write')")
    public ResponseEntity save(@RequestBody InstitutionDto request) throws Exception {
        institutionFacade.save(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstitutionDto> findById(@PathVariable Long id) throws Exception {
        var response = institutionFacade.findOrThrowNotFound(id);

        return ResponseEntity.ok(response);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_REMOVE_INSTITUTION') and hasAuthority('SCOPE_write')")
    public ResponseEntity delete(@RequestParam  Long id) throws Exception {
        institutionFacade.delete(id);
        return ResponseEntity.noContent().build();
    }

}
