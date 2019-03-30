package br.com.namao.integra.models.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = -7460208601505609597L;

    private String usuario;

    private String senha;

    private String token;

    private String role;
}
