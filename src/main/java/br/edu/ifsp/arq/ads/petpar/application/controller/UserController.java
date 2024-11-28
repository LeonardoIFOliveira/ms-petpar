package br.edu.ifsp.arq.ads.petpar.application.controller;

import br.edu.ifsp.arq.ads.petpar.application.dto.UserDto;
import br.edu.ifsp.arq.ads.petpar.domain.service.UserService;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

    @Operation(description = "Loga usuário")
    @GetMapping("/login")
    @PreAuthorize("hasRole('ROLE_SEARCH_USER') and hasAuthority('SCOPE_read')")
    public ResponseEntity listByInstitutionId( @RequestParam String email, @RequestParam String senha) throws Exception {
        userService.login(email,senha);
        return ResponseEntity.noContent().build();
    }


    @Operation(description="Salva usuário na base de dados")
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_REGISTER_USER') and hasAuthority('SCOPE_write')")
    public ResponseEntity save(@RequestBody UserDto request) throws Exception {

        userService.save(mapper.toEntity(request));
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Seleciona usuário por id")
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_SEARCH_USER') and hasAuthority('SCOPE_read')")
    public ResponseEntity<UserDto> findById( @PathVariable Long id) throws Exception {
        var response = mapper.toDataTransferObject(userService.findOrThrowNotFound(id));

        return ResponseEntity.ok(response);
    }

    @Operation(description = "Deleta usuário na base de dados")
    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_REMOVE_USER') and hasAuthority('SCOPE_write')")
    public ResponseEntity delete( @RequestParam Long id) throws Exception {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}