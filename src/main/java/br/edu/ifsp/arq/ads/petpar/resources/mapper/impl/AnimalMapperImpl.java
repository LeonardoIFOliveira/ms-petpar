package br.edu.ifsp.arq.ads.petpar.resources.mapper.impl;

import br.edu.ifsp.arq.ads.petpar.application.dto.AnimalDto;
import br.edu.ifsp.arq.ads.petpar.application.dto.GenderDto;
import br.edu.ifsp.arq.ads.petpar.application.dto.SpecieTypeDto;
import br.edu.ifsp.arq.ads.petpar.application.dto.StatusAdoptionDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.AnimalEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.UserEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.Gender;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.SpecieType;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.StatusAdoption;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.AnimalMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
@Component
public class AnimalMapperImpl implements AnimalMapper {
    @Override
    public AnimalEntity toEntity(AnimalDto animalDto) {
        return AnimalEntity
                .builder()
                .name(animalDto.getName())
                .description(animalDto.getDescription())
                .birthDate(animalDto.getBirthDate())
                .gender(Gender.valueOf(animalDto.getGender().name()))
                .type(SpecieType.valueOf(animalDto.getType().name()))
                .statusAdoption(StatusAdoption.valueOf(animalDto.getStatusAdoption().name()))
                .photoUrl(animalDto.getPhotoUrl())
                .user(animalDto.getUserId()==null ? null : UserEntity.builder().id(animalDto.getUserId()).build())
                .institution(animalDto.getInstitutionId()==null ? null : InstitutionEntity.builder().id(animalDto.getInstitutionId()).build())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Override
    public AnimalDto toDataTransferObject(AnimalEntity animalEntity) {
        return AnimalDto
                .builder()
                .id(animalEntity.getId())
                .name(animalEntity.getName())
                .description(animalEntity.getDescription())
                .birthDate(animalEntity.getBirthDate())
                .gender(GenderDto.valueOf(animalEntity.getGender().name()))
                .type(SpecieTypeDto.valueOf(animalEntity.getType().name()))
                .photoUrl(animalEntity.getPhotoUrl())
                .statusAdoption(StatusAdoptionDto.valueOf(animalEntity.getStatusAdoption().name()))
                .userId(animalEntity.getUser()== null ? null:animalEntity.getUser().getId())
                .institutionId(animalEntity.getInstitution()== null ? null:animalEntity.getInstitution().getId())
                .build();
    }

    @Override
    public List<AnimalDto> toDataTransferObjectList(List<AnimalEntity> listAnimalsByInstitution) {
        if (listAnimalsByInstitution == null || listAnimalsByInstitution.isEmpty()) {
            return Collections.emptyList();
        }
        return listAnimalsByInstitution.stream()
                .map(this::toDataTransferObject)
                .toList();
    }
}
