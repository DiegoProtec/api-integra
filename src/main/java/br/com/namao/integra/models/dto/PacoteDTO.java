package br.com.namao.integra.models.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class PacoteDTO implements Serializable {

    private Double valor;

    private PessoaDTO remetente;

    private PessoaDTO destinatario;

}
