package br.edu.ifsp.arq.ads.petpar.application.facade;

import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import br.edu.ifsp.arq.ads.petpar.domain.service.AdoptionService;
import br.edu.ifsp.arq.ads.petpar.domain.service.AnimalService;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.AnimalMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class AdoptionFacade {

    private final AdoptionService service;
    public void updateAdoptionStatus(Long userId, Long animalId, StatusAdoption status) throws Exception {
        service.updateAdoptionStatus(userId,animalId,status);
    }
}
