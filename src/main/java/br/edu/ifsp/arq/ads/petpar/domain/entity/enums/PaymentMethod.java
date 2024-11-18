package br.edu.ifsp.arq.ads.petpar.domain.entity.enums;

public enum PaymentMethod {
    PIX("PIX"),
    CARTAO("CARTAO");

    private String method;

    PaymentMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return method;
    }
}
