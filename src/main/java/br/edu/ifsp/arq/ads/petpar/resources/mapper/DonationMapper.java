package br.edu.ifsp.arq.ads.petpar.resources.mapper;

import br.edu.ifsp.arq.ads.petpar.application.dto.DonationDto;
import br.edu.ifsp.arq.ads.petpar.application.dto.UserDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.DonationEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DonationMapper {

    DonationEntity toEntity(DonationDto donationDto);

    DonationDto toDataTransferObject(DonationEntity donationEntity);
}
