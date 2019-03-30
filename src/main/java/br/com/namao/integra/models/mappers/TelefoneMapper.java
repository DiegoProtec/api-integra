package br.com.namao.integra.models.mappers;

import br.com.namao.integra.models.dtos.TelefoneDTO;
import br.com.namao.integra.models.entities.Telefone;
import br.com.namao.integra.models.enums.TipoTelefoneEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TelefoneMapper extends BaseMapper<Telefone, TelefoneDTO> {

    @Mapping(source = "tipoTelefone", target = "tipoTelefone", qualifiedByName = "tipoTelefoneToDto")
    TelefoneDTO toDTO(Telefone telefone);

    @Mapping(source = "tipoTelefone", target = "tipoTelefone", qualifiedByName = "tipoTelefoneToEntity")
    Telefone toEntity(TelefoneDTO telefoneDTO);

    @Named("tipoTelefoneToDto")
    default String tipoTelefoneToDto(Telefone telefone) {
        if (telefone == null) {
            return null;
        }
        return telefone.getTipoTelefone().getValue();
    }

    @Named("tipoTelefoneToEntity")
    default TipoTelefoneEnum tipoTelefoneToEntity(TelefoneDTO telefoneDTO) {
        if (telefoneDTO == null) {
            return null;
        }
        return TipoTelefoneEnum.valueOf(telefoneDTO.getTelefone());
    }

}
