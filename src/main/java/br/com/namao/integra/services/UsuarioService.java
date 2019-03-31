package br.com.namao.integra.services;

import br.com.namao.integra.config.security.UserSS;
import br.com.namao.integra.models.entities.Usuario;
import br.com.namao.integra.models.enums.PerfilEnum;
import br.com.namao.integra.repositories.UsuarioRepository;
import br.com.namao.integra.services.exceptions.AuthorizationException;
import br.com.namao.integra.services.exceptions.CustomNotFound;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends AbstractCrudService<Usuario, Long, UsuarioRepository> {


    UsuarioService(UsuarioRepository repository) {
        super(repository);
    }

    Usuario findByUsuario(String usuario) {
        return repository.findByUsuario(usuario)
                .orElseThrow(() -> new CustomNotFound("Usuário: " + usuario + ", não encontrado."));
    }

    @Override
    public Usuario buscarPorId(Long id) {
        UserSS userSS = UserService.userSS();
        if (userSS != null && !userSS.hasRole(PerfilEnum.ADMIN) && !id.equals(userSS.getId())) {
            throw new AuthorizationException("Acesso negado");
        }
        return repository
                .findById(id)
                .orElseThrow(() -> new CustomNotFound("Usuário, código: " + id + ", não encontrado."));
    }

}
