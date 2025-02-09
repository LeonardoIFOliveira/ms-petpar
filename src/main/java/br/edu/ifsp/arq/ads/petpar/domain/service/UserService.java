package br.edu.ifsp.arq.ads.petpar.domain.service;

import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.Permission;
import br.edu.ifsp.arq.ads.petpar.domain.entity.UserEntity;
import br.edu.ifsp.arq.ads.petpar.domain.repository.PermissionRepository;
import br.edu.ifsp.arq.ads.petpar.domain.repository.UserRepository;
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
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    public UserEntity login(String name, String password) throws Exception {
        String passwordEncripted = PasswordEncodeUtil.encode(password);
        return userRepository.findByEmailAndPassword(name,passwordEncripted)
                .orElseThrow(NotFoundException::new);
    }

    //TODO saveOrUpdate
    public void save(UserEntity request) throws Exception {
        findByEmailOrCPF(request.getEmail(), request.getCpf()).ifPresentOrElse(
        institutionEntity ->{
            throw new AlreadyExistsException();
        },() -> {
            String passwordEncripted = PasswordEncodeUtil.encode(request.getPassword());
            request.setPassword(passwordEncripted);
            request.setPermissions(addCommonUserPermissions());
            userRepository.save(request);
        });

    }

    public void update(Long id, UserEntity request) {
        userRepository.findById(id).ifPresentOrElse(user -> {
            String passwordEncripted = PasswordEncodeUtil.encode(request.getPassword());
            request.setPassword(passwordEncripted);
            request.setPermissions(addCommonUserPermissions());
            request.setId(id);
            userRepository.save(request);
        }, NotFoundException::new);
    }

    public void delete(Long id) throws Exception {
        userRepository.deleteById(id);
    }
    public Optional<UserEntity> findByEmailOrCPF(String email, String cpf) throws Exception {
        return userRepository.findByEmailOrCpf(email, cpf);
    }
    public UserEntity findOrThrowNotFound(Long id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public List<Permission> addCommonUserPermissions(){
        List<Permission> permissions = new ArrayList<>();
        permissions.add(permissionRepository.findById(1L).get());
        permissions.add(permissionRepository.findById(2L).get());
        permissions.add(permissionRepository.findById(3L).get());
        return permissions;
    }
}
