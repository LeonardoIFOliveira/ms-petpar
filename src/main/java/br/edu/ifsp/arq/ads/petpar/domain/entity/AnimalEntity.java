package br.edu.ifsp.arq.ads.petpar.domain.entity;

import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.Gender;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.SpecieType;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity(name ="animals")
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
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull
    @Column(name = "birth_date")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate birthDate;
    @NotNull
    private SpecieType type;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status_adoption")
    private StatusAdoption statusAdoption;
    @Column(name = "created_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime updatedAt;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @OneToOne
    @JoinColumn(name = "institution_id")
    private InstitutionEntity institution;

}