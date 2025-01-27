package br.edu.ifsp.arq.ads.petpar.application.dto;

public enum GenderDto {

	MASCULINO("MASCULINO"),
	FEMININO("FEMININO"),
	OUTRO("OUTRO"),
	PREFIRO_NAO_DIZER("PREFIRO_NAO_DIZER");
	
	private String description;
	
	private GenderDto(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
