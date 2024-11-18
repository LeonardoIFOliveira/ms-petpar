package br.edu.ifsp.arq.ads.petpar.application.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private AdoptionService sendMessageService;


    @ApiOperation(value = "Send Message to someone, they will be send asynchronously")
    @PostMapping
    public ResponseEntity sendMessage(AdoptionPostRequest request) throws Exception {

        sendMessageService.send(request);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Send Message to someone, they will be send asynchronously")
    @GetMapping
    public ResponseEntity sendMessage(String id) throws Exception {

        sendMessageService.send(request);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Send Message to someone, they will be send asynchronously")
    @PutMapping
    public AdoptionPutRequest sendMessage(AdoptionPutRequest request) throws Exception {

        sendMessageService.send(request);
        return ResponseEntity.noContent().build();
    }

}