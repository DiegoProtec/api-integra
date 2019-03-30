package br.com.namao.integra.models.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class EnderecoDTO implements Serializable {

    private static final long serialVersionUID = 2886799079215670016L;

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String cidade;

    private String uf;

}
