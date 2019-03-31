package br.com.namao.integra.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class UsuarioDTO implements Serializable {

    private String usuario;

    @JsonIgnore
    private String senha;

}
