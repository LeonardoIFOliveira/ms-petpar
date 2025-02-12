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
        var paymentMethod= donationDto.getPaymentMethod();
        return DonationEntity
                .builder()
                .amount(donationDto.getAmount())
                .paymentMethod(paymentMethod==null ? null : PaymentMethod.valueOf(donationDto.getPaymentMethod().name()))
                .user(donationDto.getUserId()==null ? null : UserEntity.builder().id(donationDto.getUserId()).build())
                .institution(donationDto.getInstitutionId()==null ? null : InstitutionEntity.builder().id(donationDto.getInstitutionId()).build())
                .createdAt(LocalDateTime.now())
                .build();

    }

    @Override
    public DonationDto toDonationDto(DonationEntity donationEntity){
        var paymentMethod= donationEntity.getPaymentMethod();
        return DonationDto
                .builder()
                .amount(donationEntity.getAmount())
                .paymentMethod(paymentMethod==null ? null : PaymentMethodDto.valueOf(paymentMethod.name()))
                .userId(donationEntity.getUser()== null ? null:donationEntity.getUser().getId())
                .institutionId(donationEntity.getInstitution()== null ? null:donationEntity.getInstitution().getId())
                .build();

    }

    @Override
    public List<DonationDto> toDataTransferObjectList(List<DonationEntity> listOfDonations) {
        if (listOfDonations == null || listOfDonations.isEmpty()) {
            return Collections.emptyList();
        }
        return listOfDonations.stream()
                //.skip(listOfDonations.size() - 1) // Pega o último elemento
                .map(this::toDonationDto)
                .toList();
    }
}
