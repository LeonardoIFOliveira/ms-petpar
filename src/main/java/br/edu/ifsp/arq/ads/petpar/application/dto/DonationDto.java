package br.edu.ifsp.arq.ads.petpar.application.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.PaymentMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DonationDto {

	private Long id;
	private Double amount;
	private PaymentMethod paymentMethod;
	private LocalDate data;
	private Long institutionId;
	private Long userId;

}
