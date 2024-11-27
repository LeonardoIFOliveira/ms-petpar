package br.edu.ifsp.arq.ads.petpar.domain.entity;


import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonFormat;
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
	@Column(name = "payment_method")
	private PaymentMethod paymentMethod;
	@Column(name = "created_at")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime createdAt;
	@OneToOne
	@JoinColumn(name = "institution_id")
	private InstitutionEntity institution;
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

}
