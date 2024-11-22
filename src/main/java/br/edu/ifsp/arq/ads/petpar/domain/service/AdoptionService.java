package br.edu.ifsp.arq.ads.petpar.domain.service;

import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class AdoptionService {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private UserService userService;


    public void updateAdoptionStatus(Long userId, Long animalId, StatusAdoption statusAdoption) throws Exception {
        try {
            var user = userService.findOrThrowNotFound(userId);
            var animal= animalService.findOrThrowNotFound(animalId);
            animal.setStatusAdoption(statusAdoption);
            animal.setUserEntity(user);
            animal.setUpdatedAt(LocalDateTime.now());
        } catch(Exception exception){
            throw exception;
        }


    }


    public void resetAdoptionStatus(Integer requestAmount, Integer monthPeriod) {
        animalService.listAnimalsByStatus(1,requestAmount, List.of(StatusAdoption.PENDING_TAKE_ANIMAL)).forEach(animal ->{
            if(animal.getUpdatedAt().plusMonths(monthPeriod).isBefore(LocalDateTime.now())){
                animal.setStatusAdoption(StatusAdoption.PENDING_ADOPTION);
                animal.setUpdatedAt(LocalDateTime.now());
                animal.setUserEntity(null);
                try {
                    animalService.save(animal);
                } catch (Exception exception) {
                    throw new RuntimeException("Erro na integração com a base");
                }
            }

        });
    }
}
