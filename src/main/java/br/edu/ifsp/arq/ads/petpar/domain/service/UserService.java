package br.edu.ifsp.arq.ads.petpar.domain.service;

import br.edu.ifsp.arq.ads.petpar.domain.entity.UserEntity;
import br.edu.ifsp.arq.ads.petpar.domain.repository.UserRepository;
import br.edu.ifsp.arq.ads.petpar.resources.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity login(String name, String password) throws Exception {
        return userRepository.findByNameAndPassword(name,password)
                .orElseThrow(NotFoundException::new);
    }

    public void save(UserEntity request) throws Exception {
        userRepository.save(request);
    }

    public void delete(UserEntity request) throws Exception {
        userRepository.delete(request);
    }
    public Optional<UserEntity> find(String id) throws Exception {
        return userRepository.findById(id);
    }
    public UserEntity findOrThrowNotFound(String id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }
}
