package br.edu.ifsp.arq.ads.petpar.resources.mapper;

import br.edu.ifsp.arq.ads.petpar.application.dto.UserDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = {LocalDateTime.class})
public interface  UserMapper {

    UserEntity toEntity(UserDto userDto);

    UserDto toDataTransferObject(UserEntity userEntity);
}
