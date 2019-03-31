package br.com.namao.integra.repositories;

import br.com.namao.integra.models.entities.Email;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<Email, Long> {
}
