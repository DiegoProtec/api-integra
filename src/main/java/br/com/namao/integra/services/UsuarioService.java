package br.com.namao.integra.services;

import br.com.namao.integra.models.entity.Usuario;
import br.com.namao.integra.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends AbstractCrudService<Usuario, Long, UsuarioRepository> {

    UsuarioService(UsuarioRepository repository) {
        super(repository);
    }

}
