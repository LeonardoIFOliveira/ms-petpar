package br.edu.ifsp.arq.ads.petpar.domain.service;

import br.edu.ifsp.arq.ads.petpar.domain.entity.AnimalEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import br.edu.ifsp.arq.ads.petpar.domain.repository.AnimalRepository;
import br.edu.ifsp.arq.ads.petpar.resources.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;


    public List<AnimalEntity> listAnimals(Integer pageNumber, Integer pageSize){
        var pageable = PageRequest.of(pageNumber,pageSize);
        return animalRepository.findOrderByCreatedAtAsc(pageable);
    }

    public List<AnimalEntity> listAnimalsByInstitution(String institutionId,Integer pageNumber, Integer pageSize){
        var pageable = PageRequest.of(pageNumber,pageSize);
        return animalRepository.findByInstitutionIdOrderByCreatedAtAsc(institutionId,pageable);
    }

    //TODO saveOrUpdate
    public void save(AnimalEntity request) throws Exception {
        animalRepository.save(request);
    }

    public void delete(Long id) throws Exception {
        animalRepository.deleteById(id);
    }
    public Optional<AnimalEntity> find(Long id) throws Exception {
        return animalRepository.findById(id);
    }
    public AnimalEntity findOrThrowNotFound(Long id) throws Exception {
        return animalRepository.findById(id).orElseThrow(NotFoundException::new);
    }
    public List<AnimalEntity> listAnimalsByStatus(Integer pageNumber, Integer pageSize, List<StatusAdoption> statusAdoptions){
        var pageable = PageRequest.of(pageNumber,pageSize);
        return animalRepository.findByInStatusOrderByCreatedAtDesc(statusAdoptions,pageable);
    }
}
