package br.edu.ifsp.arq.ads.petpar.domain.entity;

import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.Gender;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.SpecieType;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Gender gender;
    private LocalDate birthDate;
    private SpecieType type;
    private StatusAdoption statusAdoption;
    private LocalDate postedAt;
    private LocalDate adoptedAt;
    private UserEntity userEntity;
    private InstitutionEntity institution;

}