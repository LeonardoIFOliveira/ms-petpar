package br.edu.ifsp.arq.ads.petpar.application.controller;

import br.edu.ifsp.arq.ads.petpar.application.dto.DonationDto;
import br.edu.ifsp.arq.ads.petpar.domain.service.DonationService;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.DonationMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/donation")
@RequiredArgsConstructor
public class DonationController {

    @Autowired
    private DonationService donationService;
    @Autowired
    private DonationMapper mapper;


    @Operation(description = "Efetua doação")
    @PostMapping
    public ResponseEntity save(DonationDto donationDto) throws Exception {
        donationService.save(mapper.toEntity(donationDto));
        return ResponseEntity.noContent().build();
    }


    @Operation(description = "Lista Animais por status")
    @GetMapping("/list-user")
    public ResponseEntity<List<DonationDto>> listUser(String userId) throws Exception {
        var response = mapper.toDataTransferObjectList(
                donationService.listOfUser(userId));

        return ResponseEntity.ok(response);
    }

    @Operation(description = "Lista Animais por status")
    @GetMapping("/list-institution")
    public ResponseEntity<List<DonationDto>> listInstituition(String institutionId) throws Exception {
        var response = mapper.toDataTransferObjectList(
                donationService.listOfInstitution(institutionId));

        return ResponseEntity.ok(response);
    }

}