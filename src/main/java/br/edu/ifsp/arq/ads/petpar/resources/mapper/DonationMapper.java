package br.edu.ifsp.arq.ads.petpar.resources.mapper;

import br.edu.ifsp.arq.ads.petpar.application.dto.DonationDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.DonationEntity;

import java.util.List;

public interface DonationMapper {

    DonationEntity toEntity(DonationDto donationDto);

    DonationDto toDonationDto(DonationEntity donationEntity);

    List<DonationDto> toDataTransferObjectList(List<DonationEntity> listOfDonations);
}
