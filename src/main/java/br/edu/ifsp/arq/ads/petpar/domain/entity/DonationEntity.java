package br.edu.ifsp.arq.ads.petpar.domain.entity;


import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity(name ="donations")
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
	private LocalDateTime createdAt;
	@OneToOne
	private InstitutionEntity institution;
	@OneToOne
	private UserEntity userEntity;

}
