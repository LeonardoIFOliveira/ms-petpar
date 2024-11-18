package br.edu.ifsp.arq.ads.petpar.domain.service;

import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class AdoptionService {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private UserService userService;


    public void updateAdoptionStatus(String userId, String animalId, StatusAdoption statusAdoption) throws Exception {
        try {

            var user = userService.findOrThrowNotFound(userId);
            var animal= animalService.findOrThrowNotFound(animalId);
            animal.setStatusAdoption(statusAdoption);
            animal.setUserEntity(user);
            animal.setAdoptedAt(LocalDate.now());

        } catch(Exception exception){
            throw exception;
        }


    }
}
