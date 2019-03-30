package br.com.namao.integra.models.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class TelefoneDTO implements Serializable {

    private String telefone;

    private String tipoTelefone;

}
