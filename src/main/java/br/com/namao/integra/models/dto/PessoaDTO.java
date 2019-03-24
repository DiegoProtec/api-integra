package br.com.namao.integra.models.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class PessoaDTO implements Serializable {

    private String cpf;

    private String nome;

    private String telefone;

}
