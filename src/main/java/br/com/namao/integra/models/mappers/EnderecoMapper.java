package br.com.namao.integra.models.mappers;

import br.com.namao.integra.models.dtos.EnderecoDTO;
import br.com.namao.integra.models.entities.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnderecoMapper extends BaseMapper<Endereco, EnderecoDTO> {
}
