package br.com.namao.integra.services;

import br.com.namao.integra.models.entities.Usuario;
import br.com.namao.integra.repositories.UsuarioRepository;
import br.com.namao.integra.services.exceptions.CustomNotFound;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UsuarioService extends AbstractCrudService<Usuario, Long, UsuarioRepository> {


    UsuarioService(UsuarioRepository repository) {
        super(repository);
    }

    Usuario findByUsuario(String usuario) {
        return repository.findByUsuario(usuario)
                .map(UsuarioService::addRole)
                .orElseThrow(() -> new CustomNotFound("Usuário: " + usuario + ", não encontrado."));
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return repository
                .findById(id)
                .map(UsuarioService::addRole)
                .orElseThrow(() -> new CustomNotFound("Usuário, código: " + id + ", não encontrado."));
    }

    private static Usuario addRole(Usuario usuario) {
        usuario.setRoles(new HashSet<>());
        usuario.getRoles().add(usuario.getRole().name());
        return usuario;
    }

}
