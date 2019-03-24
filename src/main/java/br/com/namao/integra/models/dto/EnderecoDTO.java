package br.com.namao.integra.models.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class EnderecoDTO implements Serializable {

    private String rua;

    private String complemento;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

}
