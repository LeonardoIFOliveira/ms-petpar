package br.edu.ifsp.arq.ads.petpar.application.facade;

import br.edu.ifsp.arq.ads.petpar.application.dto.UserDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.UserEntity;
import br.edu.ifsp.arq.ads.petpar.domain.service.AnimalService;
import br.edu.ifsp.arq.ads.petpar.domain.service.UserService;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.AnimalMapper;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserFacade {

    private final UserMapper mapper;
    private final UserService userService;

    public void login(String email, String senha) throws Exception {
        userService.login(email,senha);
    }

    public void save(UserDto request) throws Exception {
        userService.save(mapper.toEntity(request));
    }

    public void update(Long id, UserDto request) {
        userService.update(id, mapper.toEntity(request));
    }

    public UserDto findOrThrowNotFound(Long id) throws Exception {
        return mapper.toDataTransferObject(userService.findOrThrowNotFound(id));
    }

    public void delete(Long id) throws Exception {
        userService.delete(id);
    }
}
