package br.com.namao.integra.services;

import br.com.namao.integra.config.security.UserSS;
import br.com.namao.integra.models.entities.Usuario;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UsuarioService usuarioService;

    public UserDetailsServiceImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioService.findByUsuario(username);
        return new UserSS(usuario.getId(), usuario.getUsuario(), usuario.getSenha(), usuario.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }

}
