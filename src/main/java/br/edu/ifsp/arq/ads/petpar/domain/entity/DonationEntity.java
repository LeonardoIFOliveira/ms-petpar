package br.edu.ifsp.arq.ads.petpar.domain.entity;


import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.PaymentMethod;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class DonationEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double amount;
	private PaymentMethod paymentMethod;
	private LocalDate data;
	private InstitutionEntity institution;
	private UserEntity userEntity;

}
