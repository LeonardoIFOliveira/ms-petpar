package br.edu.ifsp.arq.ads.petpar.application.dto;

public enum StatusAdoptionDto {
    PENDING_ADOPTION("PENDING_ADOPTION"),
    IN_PROGRESS("IN_PROGRESS"),// ira virar o status de visita
    PENDING_INSTITUTION_APPROVE("PENDING_INSTITUTION_APPROVE"),
    PENDING_TAKE_ANIMAL("PENDING_TAKE_ANIMAL"),
    DONE("DONE");

    private String value;

    StatusAdoptionDto(String description) {
        this.value = description;
    }

    public String getValue() {
        return value;
    }
}
