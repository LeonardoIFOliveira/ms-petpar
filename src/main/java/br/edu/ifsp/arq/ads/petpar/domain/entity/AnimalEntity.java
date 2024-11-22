package br.edu.ifsp.arq.ads.petpar.domain.entity;

import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.Gender;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.SpecieType;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity(name ="s")
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToOne
    private UserEntity userEntity;
    @OneToOne
    private InstitutionEntity institution;

}