package br.edu.ifsp.arq.ads.petpar.domain.repository;

import br.edu.ifsp.arq.ads.petpar.domain.entity.AnimalEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {

    List<AnimalEntity> findOrderByCreatedAtAsc(Pageable pageable);

    List<AnimalEntity> findByStatusOrderByCreatedAtAsc(StatusAdoption status, Pageable pageable);


    List<AnimalEntity> findByInstitutionIdOrderByCreatedAtAsc(String institutionId,Pageable pageable);

    List<AnimalEntity> findByInStatusOrderByCreatedAtDesc(List<StatusAdoption> statusAdoptions, Pageable pageable);
}