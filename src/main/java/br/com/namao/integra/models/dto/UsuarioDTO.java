package br.com.namao.integra.models.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class UsuarioDTO implements Serializable {

    private String email;

    private String senha;
}
