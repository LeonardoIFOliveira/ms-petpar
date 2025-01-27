package br.edu.ifsp.arq.ads.petpar.resources.mapper.impl;

import br.edu.ifsp.arq.ads.petpar.application.dto.GenderDto;
import br.edu.ifsp.arq.ads.petpar.application.dto.UserDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.UserEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.enums.Gender;
import br.edu.ifsp.arq.ads.petpar.resources.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserEntity toEntity(UserDto userDto) {
        return UserEntity
                .builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .cpf(userDto.getCpf())
                .birthDate(userDto.getBirthDate())
                .gender(Gender.valueOf(userDto.getGender().name()))
                .phoneNumber(userDto.getPhoneNumber())
                .password(userDto.getPassword())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .active(userDto.getActive())
                .build();
    }

    @Override
    public UserDto toDataTransferObject(UserEntity userEntity) {
        return UserDto
                .builder()
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .cpf(userEntity.getCpf())
                .birthDate(userEntity.getBirthDate())
                .gender(GenderDto.valueOf(userEntity.getGender().name()))
                .phoneNumber(userEntity.getPhoneNumber())
                .password(userEntity.getPassword())
                .active(userEntity.getActive())
                .build();
    }
}
