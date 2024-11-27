package br.edu.ifsp.arq.ads.petpar.application.facade;

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

}
