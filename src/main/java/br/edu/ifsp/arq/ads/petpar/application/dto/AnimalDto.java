package br.edu.ifsp.arq.ads.petpar.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AnimalDto {

    private Long id;
    private String name;
    private String description;
    private GenderDto gender;
    private LocalDate birthDate;
    private SpecieTypeDto type;
    private StatusAdoptionDto statusAdoption;
    private Long userId;
    private Long institutionId;

}