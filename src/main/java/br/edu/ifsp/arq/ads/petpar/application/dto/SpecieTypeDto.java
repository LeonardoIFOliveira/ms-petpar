package br.edu.ifsp.arq.ads.petpar.application.dto;

public enum SpecieTypeDto {

	CACHORRO("CACHORRO"),
	GATO("GATO"),
	ROEDOR("ROEDOR"),
	PEIXE("PEIXE"),
	OUTRO("OUTRO");

	private String name;

	SpecieTypeDto(String type) {
		this.name = type;
	}
	
	public String getName() {
		return name;
	}
	
}
