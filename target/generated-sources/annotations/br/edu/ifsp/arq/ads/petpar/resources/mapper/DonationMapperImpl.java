package br.edu.ifsp.arq.ads.petpar.resources.mapper;

import br.edu.ifsp.arq.ads.petpar.application.dto.DonationDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.DonationEntity;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-16T10:17:54-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class DonationMapperImpl implements DonationMapper {

    @Override
    public DonationEntity toEntity(DonationDto donationDto) {
        if ( donationDto == null ) {
            return null;
        }

        DonationEntity donationEntity = new DonationEntity();

        return donationEntity;
    }
}
