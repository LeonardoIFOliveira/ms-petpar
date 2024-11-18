package br.edu.ifsp.arq.ads.petpar.domain.entity;


import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.Gender;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class UserEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private LocalDate dateOfBirth;
	private String cpf;
	private String phoneNumber;
	private Gender gender;
	private LocalDate createdAt;

}
