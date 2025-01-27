package br.edu.ifsp.arq.ads.petpar.resources.mapper.impl;

import br.edu.ifsp.arq.ads.petpar.application.dto.DonationDto;
import br.edu.ifsp.arq.ads.petpar.application.dto.PaymentMethodDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.DonationEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.UserEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.PaymentMethod;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.DonationMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
@Component
public class DonationMapperImpl implements DonationMapper {

    @Override
    public DonationEntity toEntity(DonationDto donationDto){

        return DonationEntity
                .builder()
                .amount(donationDto.getAmount())
                .paymentMethod(PaymentMethod.valueOf(donationDto.getPaymentMethod().name()))
                .institution(InstitutionEntity.builder().id(donationDto.getInstitutionId()).build())
                .user(UserEntity.builder().id(donationDto.getUserId()).build())
                .createdAt(LocalDateTime.now())
                .build();

    }

    @Override
    public DonationDto toDonationDto(DonationEntity donationEntity){
        return DonationDto
                .builder()
                .amount(donationEntity.getAmount())
                .paymentMethod(PaymentMethodDto.valueOf(donationEntity.getPaymentMethod().name()))
                .institutionId(donationEntity.getInstitution().getId())
                .userId(donationEntity.getUser().getId())
                .build();

    }

    @Override
    public List<DonationDto> toDataTransferObjectList(List<DonationEntity> listOfDonations) {
        if (listOfDonations == null || listOfDonations.isEmpty()) {
            return Collections.emptyList();
        }
        return listOfDonations.stream()
                .skip(listOfDonations.size() - 1) // Pega o último elemento
                .map(this::toDonationDto)
                .toList();
    }
}
