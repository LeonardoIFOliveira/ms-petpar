package br.edu.ifsp.arq.ads.petpar.domain.entity.enums;

public enum StatusAdoption {
    PENDING_ADOPTION("PENDING_ADOPTION"),
    IN_PROGRESS("IN_PROGRESS"),
    PENDING_INSTITUTION_APPROVE("PENDING_INSTITUTION_APPROVE"),
    //status controlado pela instituição para saber se o adotante retirou o animal ou o animal foi entregue
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
