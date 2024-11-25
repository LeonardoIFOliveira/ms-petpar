package br.edu.ifsp.arq.ads.petpar.application.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.Gender;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserDto {

	private Long id;
	private String name;
	private String email;
	private String password;
	private LocalDate dateOfBirth;
	private String cpf;
	private String phoneNumber;
	private Gender gender;

}
