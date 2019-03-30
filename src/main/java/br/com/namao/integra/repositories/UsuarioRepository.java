package br.com.namao.integra.repositories;

import br.com.namao.integra.models.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
