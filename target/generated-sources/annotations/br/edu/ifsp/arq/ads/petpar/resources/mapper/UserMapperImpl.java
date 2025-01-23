package br.edu.ifsp.arq.ads.petpar.resources.mapper;

import br.edu.ifsp.arq.ads.petpar.application.dto.UserDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.UserEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.UserEntity.UserEntityBuilder;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-23T13:55:37-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.cpf( userDto.getCpf() );
        userEntity.email( userDto.getEmail() );
        userEntity.gender( userDto.getGender() );
        userEntity.id( userDto.getId() );
        userEntity.name( userDto.getName() );
        userEntity.password( userDto.getPassword() );
        userEntity.phoneNumber( userDto.getPhoneNumber() );

        return userEntity.build();
    }

    @Override
    public UserDto toDataTransferObject(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setCpf( userEntity.getCpf() );
        userDto.setEmail( userEntity.getEmail() );
        userDto.setGender( userEntity.getGender() );
        userDto.setId( userEntity.getId() );
        userDto.setName( userEntity.getName() );
        userDto.setPassword( userEntity.getPassword() );
        userDto.setPhoneNumber( userEntity.getPhoneNumber() );

        return userDto;
    }
}
