package br.com.namao.integra.models.mappers;

import br.com.namao.integra.models.dtos.UsuarioDTO;
import br.com.namao.integra.models.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {
}
