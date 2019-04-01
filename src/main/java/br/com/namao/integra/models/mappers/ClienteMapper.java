package br.com.namao.integra.models.mappers;

import br.com.namao.integra.models.dtos.ClienteDTO;
import br.com.namao.integra.models.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper extends BaseMapper<Cliente, ClienteDTO> {
}
