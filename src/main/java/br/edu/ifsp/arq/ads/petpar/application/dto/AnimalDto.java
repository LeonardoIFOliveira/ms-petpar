package br.edu.ifsp.arq.ads.petpar.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.Gender;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.SpecieType;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AnimalDto {


    private Long id;
    private String name;
    private String description;
    private Gender gender;
    private LocalDate birthDate;
    private SpecieType type;
    private StatusAdoption statusAdoption;
    private Long userId;
    private Long institutionId;

}