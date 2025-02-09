package br.edu.ifsp.arq.ads.petpar.application.facade;

import br.edu.ifsp.arq.ads.petpar.application.dto.AnimalDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.AnimalEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.SpecieType;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import br.edu.ifsp.arq.ads.petpar.domain.service.AnimalService;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.AnimalMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class AnimalFacade {

    private final AnimalMapper mapper;
    private final AnimalService animalService;

    public List<AnimalDto> listAnimalsByStatus(Integer pageNumber, Integer pageSize, List<SpecieType> specieTypes) {
        return mapper.toDataTransferObjectList(animalService
                .listAnimalsBySpecie(pageNumber, pageSize,specieTypes));
    }

    public List<AnimalDto> listAnimalsByInstitution(Long institutionId, Integer pageNumber, Integer pageSize) {
        return mapper.toDataTransferObjectList(
                animalService.listAnimalsByInstitution(institutionId, pageNumber, pageSize));
    }

    public void save(AnimalDto request) throws Exception {
            animalService.save(mapper.toEntity(request));
    }

    public AnimalDto findOrThrowNotFound(Long id) throws Exception {
        return mapper.toDataTransferObject(animalService.findOrThrowNotFound(id));
    }

    public void delete(Long id) throws Exception {
        animalService.delete(id);
    }

    public List<AnimalDto> listAllAnimals() {
        return mapper.toDataTransferObjectList(animalService.listAllAnimals());
    }

}
