package br.edu.ifsp.arq.ads.petpar.domain.entity.enums;

public enum StatusAdoption {
    PENDING_ADOPTION("PENDING_ADOPTION"),
    IN_PROGRESS("IN_PROGRESS"),// ira virar o status de visita
    PENDING_INSTITUTION_APPROVE("PENDING_INSTITUTION_APPROVE"),
    PENDING_TAKE_ANIMAL("PENDING_TAKE_ANIMAL"),
    DONE("DONE");

    private String value;

    StatusAdoption(String description) {
        this.value = description;
    }

    public String getValue() {
        return value;
    }
}
