package br.edu.ifsp.arq.ads.petpar.domain.repository;

import br.edu.ifsp.arq.ads.petpar.domain.entity.AnimalEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.SpecieType;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {

    List<AnimalEntity> findAllByOrderByCreatedAtAsc(Pageable pageable);

    //List<AnimalEntity> findByStatusAdoptionOrderByCreatedAtAsc(StatusAdoption status, Pageable pageable);


    List<AnimalEntity> findByInstitutionIdOrderByCreatedAtAsc(Long institutionId,Pageable pageable);

    List<AnimalEntity> findByTypeInOrderByCreatedAtDesc(List<SpecieType> specie, Pageable pageable);

    List<AnimalEntity> findAll();

    @Query("SELECT a FROM animals a WHERE " +
            "(:species IS NULL OR a.type = :species) AND " +
            "(:startDate IS NULL OR a.birthDate >= :startDate) AND " +
            "(:endDate IS NULL OR a.birthDate <= :endDate)")
    List<AnimalEntity> filterAnimals(@Param("species") SpecieType species,
                                     @Param("startDate") LocalDate startDate,
                                     @Param("endDate") LocalDate endDate);

}
