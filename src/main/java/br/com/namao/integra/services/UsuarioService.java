package br.com.namao.integra.services;

import br.com.namao.integra.models.entities.Usuario;
import br.com.namao.integra.repositories.UsuarioRepository;
import br.com.namao.integra.services.exceptions.CustomNotFound;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends AbstractCrudService<Usuario, Long, UsuarioRepository> {

    UsuarioService(UsuarioRepository repository) {
        super(repository);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new CustomNotFound("Usuário, código: " + id + ", não encontrado."));
    }

}
