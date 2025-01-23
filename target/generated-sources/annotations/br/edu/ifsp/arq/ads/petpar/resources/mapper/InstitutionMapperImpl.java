package br.edu.ifsp.arq.ads.petpar.resources.mapper;

import br.edu.ifsp.arq.ads.petpar.application.dto.InstitutionDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.InstitutionEntity.InstitutionEntityBuilder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-23T13:55:36-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class InstitutionMapperImpl implements InstitutionMapper {

    @Override
    public InstitutionEntity toEntity(InstitutionDto institutionDto) {
        if ( institutionDto == null ) {
            return null;
        }

        InstitutionEntityBuilder institutionEntity = InstitutionEntity.builder();

        institutionEntity.description( institutionDto.getDescription() );
        institutionEntity.email( institutionDto.getEmail() );
        institutionEntity.id( institutionDto.getId() );
        institutionEntity.name( institutionDto.getName() );
        institutionEntity.password( institutionDto.getPassword() );
        institutionEntity.phoneNumber( institutionDto.getPhoneNumber() );

        return institutionEntity.build();
    }

    @Override
    public InstitutionDto toDataTransferObject(InstitutionEntity institutionEntity) {
        if ( institutionEntity == null ) {
            return null;
        }

        InstitutionDto institutionDto = new InstitutionDto();

        institutionDto.setDescription( institutionEntity.getDescription() );
        institutionDto.setEmail( institutionEntity.getEmail() );
        institutionDto.setId( institutionEntity.getId() );
        institutionDto.setName( institutionEntity.getName() );
        institutionDto.setPassword( institutionEntity.getPassword() );
        institutionDto.setPhoneNumber( institutionEntity.getPhoneNumber() );

        return institutionDto;
    }

    @Override
    public List<InstitutionDto> toDataTransferObjectList(List<InstitutionEntity> institutionEntity) {
        if ( institutionEntity == null ) {
            return null;
        }

        List<InstitutionDto> list = new ArrayList<InstitutionDto>( institutionEntity.size() );
        for ( InstitutionEntity institutionEntity1 : institutionEntity ) {
            list.add( toDataTransferObject( institutionEntity1 ) );
        }

        return list;
    }
}
