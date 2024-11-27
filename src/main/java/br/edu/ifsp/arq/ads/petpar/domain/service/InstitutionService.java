package br.edu.ifsp.arq.ads.petpar.domain.service;

import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import br.edu.ifsp.arq.ads.petpar.domain.repository.InstitutionRepository;
import br.edu.ifsp.arq.ads.petpar.domain.utils.PasswordEncodeUtil;
import br.edu.ifsp.arq.ads.petpar.resources.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    public InstitutionEntity login(String name, String password) throws Exception {
        String passwordEncripted = PasswordEncodeUtil.encode(password);
        return institutionRepository.findByNameAndPassword(name,passwordEncripted)
                .orElseThrow(NotFoundException::new);
    }

    //TODO saveOrUpdate
    public void save(InstitutionEntity request) throws Exception {
        findByEmailOrCPF(request.getEmail(), request.getCpfCnpj()).orElseGet(() -> {
            String passwordEncripted = PasswordEncodeUtil.encode(request.getPassword());
            request.setPassword(passwordEncripted);
            institutionRepository.save(request);
            return request;
        });

    }

    public void delete(Long id) throws Exception {
        institutionRepository.deleteById(id);
    }
    public Optional<InstitutionEntity> findByEmailOrCPF(String email, String cpf) throws Exception {
        return institutionRepository.findByEmailOrCpfCnpj(email, cpf);
    }
    public InstitutionEntity findOrThrowNotFound(Long id) throws Exception {
        return institutionRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public List<InstitutionEntity> list() {
        return institutionRepository.findAll();
    }
}
