package br.edu.ifsp.arq.ads.petpar.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
@Entity(name ="institutions")
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
    private String cpfCnpj;
    private String phoneNumber;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToMany(fetch = FetchType.EAGER) // fetch = buscar - eager = ancioso
    @JoinTable(name = "user_permission", joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_permission"))
    private List<Permission> permissions;

}
