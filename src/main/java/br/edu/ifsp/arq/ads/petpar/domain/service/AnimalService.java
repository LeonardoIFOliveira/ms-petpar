package br.edu.ifsp.arq.ads.petpar.domain.service;

import br.edu.ifsp.arq.ads.petpar.domain.entity.AnimalEntity;
import br.edu.ifsp.arq.ads.petpar.domain.repository.AnimalRepository;
import br.edu.ifsp.arq.ads.petpar.resources.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;


    private List<AnimalEntity> listAnimals(Integer pageNumber, Integer pageSize){
        var pageable = Pageable.ofSize(100);
        return animalRepository.findOrderByCreatedAtAsc(pageable);
    }

    public void save(AnimalEntity request) throws Exception {
        animalRepository.save(request);
    }

    public void delete(AnimalEntity request) throws Exception {
        animalRepository.delete(request);
    }
    public Optional<AnimalEntity> find(String id) throws Exception {
        return animalRepository.findById(id);
    }
    public AnimalEntity findOrThrowNotFound(String id) throws Exception {
        return animalRepository.findById(id).orElseThrow(NotFoundException::new);
    }

}
