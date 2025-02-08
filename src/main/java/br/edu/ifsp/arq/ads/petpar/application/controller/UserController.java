package br.edu.ifsp.arq.ads.petpar.application.controller;

import br.edu.ifsp.arq.ads.petpar.application.dto.UserDto;
import br.edu.ifsp.arq.ads.petpar.application.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("/login")
//    @PreAuthorize("hasRole('ROLE_SEARCH_USER') and hasAuthority('SCOPE_read')")
    public ResponseEntity listByInstitutionId( @RequestParam String email, @RequestParam String senha) throws Exception {
        userFacade.login(email,senha);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserDto request) throws Exception {

        userFacade.save(request);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
//    @PreAuthorize("hasAuthority('ROLE_REGISTER_INSTITUTION') and hasAuthority('SCOPE_write')")
    public ResponseEntity update(@RequestBody UserDto request, @RequestParam Long id) throws Exception {
        userFacade.update(id, request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasRole('ROLE_SEARCH_USER') and hasAuthority('SCOPE_read')")
    public ResponseEntity<UserDto> findById( @PathVariable Long id) throws Exception {
        var response = userFacade.findOrThrowNotFound(id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping
//    @PreAuthorize("hasAuthority('ROLE_REMOVE_USER') and hasAuthority('SCOPE_write')")
    public ResponseEntity delete( @RequestParam Long id) throws Exception {
        userFacade.delete(id);
        return ResponseEntity.noContent().build();
    }

}