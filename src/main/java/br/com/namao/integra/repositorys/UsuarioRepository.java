package br.com.namao.integra.repositorys;

import br.com.namao.integra.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}