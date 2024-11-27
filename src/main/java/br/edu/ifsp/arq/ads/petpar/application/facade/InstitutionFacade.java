package br.edu.ifsp.arq.ads.petpar.application.facade;

import br.edu.ifsp.arq.ads.petpar.application.dto.InstitutionDto;
import br.edu.ifsp.arq.ads.petpar.domain.service.AnimalService;
import br.edu.ifsp.arq.ads.petpar.domain.service.InstitutionService;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.AnimalMapper;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.InstitutionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class InstitutionFacade {

    private final InstitutionMapper mapper;
    private final InstitutionService institutionService;

    public List<InstitutionDto> list() {
        return mapper.toDataTransferObjectList(institutionService.list());
    }

    public void login(String email, String senha) throws Exception {
        institutionService.login(email, senha);
    }

    public void save(InstitutionDto request) throws Exception {
        institutionService.save(mapper.toEntity(request));
    }

    public InstitutionDto findOrThrowNotFound(Long id) throws Exception {
        return mapper.toDataTransferObject(institutionService.findOrThrowNotFound(id));
    }

    public void delete(Long id) throws Exception {
        institutionService.delete(id);
    }
}
