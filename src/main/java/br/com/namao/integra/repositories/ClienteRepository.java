package br.com.namao.integra.repositories;

import br.com.namao.integra.models.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
