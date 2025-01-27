package br.edu.ifsp.arq.ads.petpar.domain.repository;


import br.edu.ifsp.arq.ads.petpar.domain.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
