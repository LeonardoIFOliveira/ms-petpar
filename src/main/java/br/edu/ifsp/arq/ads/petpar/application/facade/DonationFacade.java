package br.edu.ifsp.arq.ads.petpar.application.facade;

import br.edu.ifsp.arq.ads.petpar.application.dto.DonationDto;
import br.edu.ifsp.arq.ads.petpar.application.dto.InstitutionDto;
import br.edu.ifsp.arq.ads.petpar.domain.service.DonationService;
import br.edu.ifsp.arq.ads.petpar.domain.service.InstitutionService;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.DonationMapper;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.InstitutionMapper;
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
    private final InstitutionService institutionService;
    private final InstitutionMapper institutionMapper;

    public List<DonationDto> listOfUser(Long userId) throws Exception {
        return mapper.toDataTransferObjectList(
                donationService.listOfUser(userId));
    }

    public List<DonationDto> listOfInstitution(Long institutionId) throws Exception {
        return mapper.toDataTransferObjectList(
                donationService.listOfInstitution(institutionId));
    }

    public List<InstitutionDto> listOfInstitution(){
        return institutionMapper.toDataTransferObjectList(institutionService.list().stream().filter( institutionEntity -> institutionEntity.getActive()).toList());
    }

    public void save(DonationDto donationDto) throws Exception {
        donationService.save(mapper.toEntity(donationDto));
    }
}
