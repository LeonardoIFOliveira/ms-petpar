package br.edu.ifsp.arq.ads.petpar.domain.entity;


import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name ="users")
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
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	@ManyToMany(fetch = FetchType.EAGER) // fetch = buscar - eager = ancioso
	@JoinTable(name = "user_permission", joinColumns = @JoinColumn(name = "id_user"),
			inverseJoinColumns = @JoinColumn(name = "id_permission"))
	private List<Permission> permissions;

}
