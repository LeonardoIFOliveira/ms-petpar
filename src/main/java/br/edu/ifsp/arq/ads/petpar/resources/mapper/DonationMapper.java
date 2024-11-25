package br.edu.ifsp.arq.ads.petpar.resources.mapper;

import br.edu.ifsp.arq.ads.petpar.application.dto.DonationDto;
import br.edu.ifsp.arq.ads.petpar.application.dto.UserDto;
import br.edu.ifsp.arq.ads.petpar.domain.entity.DonationEntity;
import br.edu.ifsp.arq.ads.petpar.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = {LocalDateTime.class, DonationEntity.class})
public interface DonationMapper {


//    @Mapping(source = "institutionId", target = "institution.id")
//    @Mapping(source = "userId", target = "user.id")
//    @Mapping(expression = "java(LocalDateTime.now())", target = "createdAt")

    @Mapping(target = "institution.id", expression = "java(Objects.nonNull(institutionId) ? institutionId ? null)")
    @Mapping(target = "user.id", expression = "java(Objects.nonNull(userId) ? userId ? null)")
    @Mapping(expression = "java(LocalDateTime.now())", target = "createdAt")
    DonationEntity toEntity(DonationDto donationDto, String institutionId, String userId);

    @Mapping(source = "institutionId", target = "institution.id")
    @Mapping(source = "userId", target = "user.id")
    List<DonationDto> toDataTransferObjectList(List<DonationEntity> listOfUser);


}
