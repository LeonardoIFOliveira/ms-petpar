package br.edu.ifsp.arq.ads.petpar.application.controller;

import br.edu.ifsp.arq.ads.petpar.application.dto.LoginDto;
import br.edu.ifsp.arq.ads.petpar.application.dto.UserDto;
import br.edu.ifsp.arq.ads.petpar.application.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping
//    @PreAuthorize("hasRole('ROLE_SEARCH_USER') and hasAuthority('SCOPE_read')")
    public ResponseEntity<LoginDto> login(@RequestParam String email, @RequestParam String password) throws Exception {
        var login = userFacade.login(email,password);
        return ResponseEntity.ok(login);
    }

    //@PostMapping
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