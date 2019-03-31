package br.com.namao.integra.services;

import br.com.namao.integra.config.security.UserSS;
import br.com.namao.integra.models.entities.Usuario;
import br.com.namao.integra.models.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioService.findByUsuario(username);
        Set<RoleEnum> roleEnums = new HashSet<>();
        roleEnums.add(usuario.getRole());
        return new UserSS(usuario.getId(), usuario.getUsuario(), usuario.getSenha(), roleEnums.stream().map(x -> new SimpleGrantedAuthority(x.getValue())).collect(Collectors.toList()));
    }

}
