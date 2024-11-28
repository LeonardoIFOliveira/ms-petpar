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
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "institution_id", referencedColumnName = "id")
	private InstitutionEntity institutionId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity userId;

}
