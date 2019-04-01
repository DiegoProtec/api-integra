package br.com.namao.integra.models.mappers;

import br.com.namao.integra.models.dtos.TelefoneDTO;
import br.com.namao.integra.models.entities.Telefone;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TelefoneMapper extends BaseMapper<Telefone, TelefoneDTO> {
}
