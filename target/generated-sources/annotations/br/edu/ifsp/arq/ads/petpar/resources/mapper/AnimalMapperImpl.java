package br.edu.ifsp.arq.ads.petpar.resources.mapper;

import br.edu.ifsp.arq.ads.petpar.application.dto.AnimalDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.AnimalEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.AnimalEntity.AnimalEntityBuilder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-23T13:55:37-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class AnimalMapperImpl implements AnimalMapper {

    @Override
    public AnimalEntity toEntity(AnimalDto animalDto) {
        if ( animalDto == null ) {
            return null;
        }

        AnimalEntityBuilder animalEntity = AnimalEntity.builder();

        animalEntity.birthDate( animalDto.getBirthDate() );
        animalEntity.description( animalDto.getDescription() );
        animalEntity.gender( animalDto.getGender() );
        animalEntity.id( animalDto.getId() );
        animalEntity.name( animalDto.getName() );
        animalEntity.statusAdoption( animalDto.getStatusAdoption() );
        animalEntity.type( animalDto.getType() );

        return animalEntity.build();
    }

    @Override
    public AnimalDto toDataTransferObject(AnimalEntity animalEntity) {
        if ( animalEntity == null ) {
            return null;
        }

        AnimalDto animalDto = new AnimalDto();

        animalDto.setBirthDate( animalEntity.getBirthDate() );
        animalDto.setDescription( animalEntity.getDescription() );
        animalDto.setGender( animalEntity.getGender() );
        animalDto.setId( animalEntity.getId() );
        animalDto.setName( animalEntity.getName() );
        animalDto.setStatusAdoption( animalEntity.getStatusAdoption() );
        animalDto.setType( animalEntity.getType() );

        return animalDto;
    }

    @Override
    public List<AnimalDto> toDataTransferObjectList(List<AnimalEntity> listAnimalsByInstitution) {
        if ( listAnimalsByInstitution == null ) {
            return null;
        }

        List<AnimalDto> list = new ArrayList<AnimalDto>( listAnimalsByInstitution.size() );
        for ( AnimalEntity animalEntity : listAnimalsByInstitution ) {
            list.add( toDataTransferObject( animalEntity ) );
        }

        return list;
    }
}
