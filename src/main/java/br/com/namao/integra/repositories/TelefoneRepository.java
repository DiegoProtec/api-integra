package br.com.namao.integra.repositories;

import br.com.namao.integra.models.entities.Telefone;
import org.springframework.data.repository.CrudRepository;

public interface TelefoneRepository extends CrudRepository<Telefone, Long> {
}
