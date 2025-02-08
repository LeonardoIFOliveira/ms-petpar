package br.edu.ifsp.arq.ads.petpar.application.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum GenderDto {

	MASCULINO("MASCULINO"),
	FEMININO("FEMININO"),
	OUTRO("OUTRO"),
	PREFIRO_NAO_DIZER("PREFIRO_NAO_DIZER");

	private final String description;

	private GenderDto(String description) {
		this.description = description;
	}

    @JsonCreator
	public static GenderDto fromString(String value) {
		if (value == null || value.trim().isEmpty()) {
			return null; // Ou um valor padrão, como PREFIRO_NAO_DIZER
		}
		for (GenderDto gender : GenderDto.values()) {
			if (gender.description.equalsIgnoreCase(value.trim())) {
				return gender;
			}
		}
		throw new IllegalArgumentException("Valor inválido para GenderDto: " + value);
	}
}
