package br.edu.ifsp.arq.ads.petpar.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class InstitutionDto {

    private Long id;
    private String name;
    private String description;
    private String email;
    private String cpfOrCnpj;
    private String phoneNumber;
    private String password;
    private LocalDate createdAt;

}
