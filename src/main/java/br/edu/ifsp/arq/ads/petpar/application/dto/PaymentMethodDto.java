package br.edu.ifsp.arq.ads.petpar.application.dto;

public enum PaymentMethodDto {
    PIX("PIX"),
    CARTAO("CARTAO");

    private String method;

    PaymentMethodDto(String method) {
        this.method = method;
    }

    public String getDescription() {
        return method;
    }
}
