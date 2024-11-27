package br.edu.ifsp.arq.ads.petpar.resources.mapper;

import br.edu.ifsp.arq.ads.petpar.application.dto.InstitutionDto;
import br.edu.ifsp.arq.ads.petpar.application.dto.UserDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = {LocalDateTime.class})
public interface InstitutionMapper {

    InstitutionEntity toEntity(InstitutionDto institutionDto);

    InstitutionDto toDataTransferObject(InstitutionEntity institutionEntity);

    List<InstitutionDto> toDataTransferObjectList(List<InstitutionEntity> institutionEntity);
}
