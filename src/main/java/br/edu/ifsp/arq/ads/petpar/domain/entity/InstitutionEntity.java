package br.edu.ifsp.arq.ads.petpar.domain.entity;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class InstitutionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String email;
    private String cpfOrCnpj;
    private String phoneNumber;
    private String password;
    private LocalDate createdAt;

}
