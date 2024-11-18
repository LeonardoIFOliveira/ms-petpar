package br.edu.ifsp.arq.ads.petpar.domain.repository;

import br.edu.ifsp.arq.ads.petpar.domain.entity.DonationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepository extends JpaRepository<DonationEntity, String> {

}