package br.edu.ifsp.arq.ads.petpar.resources.mapper;

import br.edu.ifsp.arq.ads.petpar.application.dto.AnimalDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.AnimalEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    AnimalEntity toEntity(AnimalDto animalDto);

    AnimalDto toDataTransferObject(AnimalEntity animalEntity);

    List<AnimalDto> toDataTransferObjectList(List<AnimalEntity> listAnimalsByInstitution);
}