package br.edu.ifsp.arq.ads.petpar.application.facade;

import br.edu.ifsp.arq.ads.petpar.application.dto.DonationDto;
import br.edu.ifsp.arq.ads.petpar.domain.service.AnimalService;
import br.edu.ifsp.arq.ads.petpar.domain.service.DonationService;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.AnimalMapper;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.DonationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DonationFacade {

    private final DonationMapper mapper;
    private final DonationService donationService;

    public List<DonationDto> listOfUser(String userId) throws Exception {
//        return mapper.toDataTransferObjectList(
//                donationService.listOfUser(userId));
        return null;
    }

    public List<DonationDto> listOfInstitution(String institutionId) throws Exception {
//        return mapper.toDataTransferObjectList(
//                donationService.listOfInstitution(institutionId));
        return null;
    }

    public void save(DonationDto donationDto, String institutionId, String userId) throws Exception {
        donationService.save(mapper.toEntity(donationDto));
    }
}
