package br.edu.ifsp.arq.ads.petpar.domain.repository;

import br.edu.ifsp.arq.ads.petpar.domain.entity.UserEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.UserPermitionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPermitionRepository extends JpaRepository<UserPermitionsEntity, Long> {
    Optional<UserPermitionsEntity> findByEmail(String email);
}