package br.com.namao.integra.repositories;

import br.com.namao.integra.models.entities.EmailEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<EmailEntity, Long> {
}
