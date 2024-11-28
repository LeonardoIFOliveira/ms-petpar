package br.edu.ifsp.arq.ads.petpar.application.controller;

import br.edu.ifsp.arq.ads.petpar.application.dto.DonationDto;
import br.edu.ifsp.arq.ads.petpar.application.facade.DonationFacade;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/donation")
@RequiredArgsConstructor
public class DonationController {

    @Autowired
    private DonationFacade donationFacade;

    @Operation(description = "Efetua doação")
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_REGISTER_INSTITUTION') and hasAuthority('SCOPE_write')")
    public ResponseEntity save(DonationDto donationDto, String institutionId,String userId) throws Exception {
        donationFacade.save(donationDto, institutionId, userId);
        return ResponseEntity.noContent().build();
    }


    @Operation(description = "Lista Animais por status")
    @GetMapping("/list-user")
    @PreAuthorize("hasRole('ROLE_SEARCH_USER') and hasAuthority('SCOPE_read')")
    public ResponseEntity<List<DonationDto>> listUser(String userId) throws Exception {
        var response = donationFacade.listOfUser(userId);

        return ResponseEntity.ok(response);
    }

    @Operation(description = "Lista Animais por status")
    @GetMapping("/list-institution")
    @PreAuthorize("hasRole('ROLE_SEARCH_INSTITUTION') and hasAuthority('SCOPE_read')")
    public ResponseEntity<List<DonationDto>> listInstituition(String institutionId) throws Exception {
        var response = donationFacade.listOfInstitution(institutionId);
        return ResponseEntity.ok(response);
    }

}