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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1/donation")
public class DonationController {

    @Autowired
    private DonationFacade donationFacade;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_REGISTER_INSTITUTION') and hasAuthority('SCOPE_write')")
    public ResponseEntity save( @RequestBody DonationDto donationDto) throws Exception {
        donationFacade.save(donationDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list-user")
    @PreAuthorize("hasRole('ROLE_SEARCH_USER') and hasAuthority('SCOPE_read')")
    public ResponseEntity<List<DonationDto>> listUser( @RequestParam Long userId) throws Exception {
        var response = donationFacade.listOfUser(userId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/list-institution")
    @PreAuthorize("hasRole('ROLE_SEARCH_INSTITUTION') and hasAuthority('SCOPE_read')")
    public ResponseEntity<List<DonationDto>> listInstituition(@RequestParam Long institutionId) throws Exception {
        var response = donationFacade.listOfInstitution(institutionId);
        return ResponseEntity.ok(response);
    }

}