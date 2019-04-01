package br.com.namao.integra.models.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class TelefoneDTO implements Serializable {

    private static final long serialVersionUID = 5948164806115953243L;

    private String telefone;

}
