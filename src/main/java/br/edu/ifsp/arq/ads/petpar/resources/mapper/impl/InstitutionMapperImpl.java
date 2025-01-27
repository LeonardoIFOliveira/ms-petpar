package br.edu.ifsp.arq.ads.petpar.resources.mapper.impl;

import br.edu.ifsp.arq.ads.petpar.application.dto.InstitutionDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.InstitutionMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Component
public class InstitutionMapperImpl implements InstitutionMapper {
    @Override
    public InstitutionEntity toEntity(InstitutionDto institutionDto) {
        return InstitutionEntity
                .builder()
                .name(institutionDto.getName())
                .description(institutionDto.getDescription())
                .email(institutionDto.getEmail())
                .cpfCnpj(institutionDto.getCpfOrCnpj())
                .phoneNumber(institutionDto.getPhoneNumber())
                .password(institutionDto.getPassword())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .active(institutionDto.getActive())
                .build();
    }

    @Override
    public InstitutionDto toDataTransferObject(InstitutionEntity institutionEntity) {
        return InstitutionDto
                .builder()
                .name(institutionEntity.getName())
                .description(institutionEntity.getDescription())
                .email(institutionEntity.getEmail())
                .cpfOrCnpj(institutionEntity.getCpfCnpj())
                .phoneNumber(institutionEntity.getPhoneNumber())
                .password(institutionEntity.getPassword())
                .active(institutionEntity.getActive())
                .build();
    }

    @Override
    public List<InstitutionDto> toDataTransferObjectList(List<InstitutionEntity> institutionEntity) {
        if (institutionEntity == null || institutionEntity.isEmpty()) {
            return Collections.emptyList();
        }
        return institutionEntity.stream()
                .skip(institutionEntity.size() - 1) // Pega o último elemento
                .map(this::toDataTransferObject)
                .toList();
    }
}
