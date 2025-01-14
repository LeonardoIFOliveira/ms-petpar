package br.edu.ifsp.arq.ads.petpar.domain.repository;

import br.edu.ifsp.arq.ads.petpar.domain.entity.AnimalEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstitutionRepository extends JpaRepository<InstitutionEntity, Long> {

    List<InstitutionEntity> findAllByOrderByCreatedAtAsc(Pageable pageable);

    Optional<InstitutionEntity> findByNameAndPassword(String name, String password);
    Optional<InstitutionEntity> findByEmailOrCpfCnpj(String name, String cpfOrCnpj);

    Optional<InstitutionEntity> findByEmail(String email);
}