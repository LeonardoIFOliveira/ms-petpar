package br.edu.ifsp.arq.ads.petpar.domain.service;

import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.Permission;
import br.edu.ifsp.arq.ads.petpar.domain.repository.InstitutionRepository;
import br.edu.ifsp.arq.ads.petpar.domain.repository.PermissionRepository;
import br.edu.ifsp.arq.ads.petpar.domain.utils.PasswordEncodeUtil;
import br.edu.ifsp.arq.ads.petpar.resources.exception.AlreadyExistsException;
import br.edu.ifsp.arq.ads.petpar.resources.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    public InstitutionEntity login(String name, String password) throws Exception {
        String passwordEncripted = PasswordEncodeUtil.encode(password);
        return institutionRepository.findByNameAndPassword(name,passwordEncripted)
                .orElseThrow(NotFoundException::new);
    }

    //TODO saveOrUpdate
    public void save(InstitutionEntity request) throws Exception {

        findByEmailOrCPF(request.getEmail(), request.getCpfCnpj()).ifPresentOrElse(
            institutionEntity ->{
                throw new AlreadyExistsException();
            },() -> {
            String passwordEncripted = PasswordEncodeUtil.encode(request.getPassword());
            request.setPassword(passwordEncripted);
            request.setPermissions(addCommonUserPermissions());
            institutionRepository.save(request);
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

    public void update(Long id, InstitutionEntity request) {
        institutionRepository.findById(id).ifPresentOrElse(institution -> {
            String passwordEncripted = PasswordEncodeUtil.encode(request.getPassword());
            request.setPassword(passwordEncripted);
            request.setId(id);
            request.setPermissions(addCommonUserPermissions());
            institutionRepository.save(request);
        }, NotFoundException::new);
    }

    public List<Permission> addCommonUserPermissions(){
        List<Permission> permissions = new ArrayList<>();
        permissions.add(permissionRepository.findById(4L).get());
        permissions.add(permissionRepository.findById(5L).get());
        permissions.add(permissionRepository.findById(6L).get());
        return permissions;
    }
}
