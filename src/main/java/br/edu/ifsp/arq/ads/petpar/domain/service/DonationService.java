package br.edu.ifsp.arq.ads.petpar.domain.service;

import br.edu.ifsp.arq.ads.petpar.domain.entity.DonationEntity;
import br.edu.ifsp.arq.ads.petpar.domain.repository.DonationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    public void save(DonationEntity request) throws Exception {
        donationRepository.save(request);
    }

    public List<DonationEntity> listOfUser(String userId) throws Exception {
        return donationRepository.findByUserId(userId);
    }

    public List<DonationEntity> listOfInstitution(String institutionId) throws Exception {
        return donationRepository.findByInstitutionId(institutionId);
    }
}