package br.com.namao.integra.models.mappers;

import br.com.namao.integra.models.dtos.EmailDTO;
import br.com.namao.integra.models.entities.Email;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmailMapper extends BaseMapper<Email, EmailDTO> {
}
