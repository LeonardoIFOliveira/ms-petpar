package br.edu.ifsp.arq.ads.petpar.domain.service;

import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import br.edu.ifsp.arq.ads.petpar.domain.repository.InstitutionRepository;
import br.edu.ifsp.arq.ads.petpar.resources.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    public InstitutionEntity login(String name, String password) throws Exception {
        return institutionRepository.findByNameAndPassword(name,password)
                .orElseThrow(NotFoundException::new);
    }

    public void save(InstitutionEntity request) throws Exception {
        institutionRepository.save(request);
    }

    public void delete(InstitutionEntity request) throws Exception {
        institutionRepository.delete(request);
    }
    public Optional<InstitutionEntity> find(String id) throws Exception {
        return institutionRepository.findById(id);
    }
    public InstitutionEntity findOrThrowNotFound(String id) throws Exception {
        return institutionRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

}
