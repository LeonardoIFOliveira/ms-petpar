package br.edu.ifsp.arq.ads.petpar.domain.entity.enums;

public enum SpecieType {

	CACHORRO("CACHORRO"),
	GATO("GATO"),
	ROEDOR("ROEDOR"),
	PEIXE("PEIXE"),
	OUTRO("OUTRO");
	
	private String name;
	
	SpecieType(String type) {
		this.name = type;
	}
	
	public String getName() {
		return name;
	}
	
}
