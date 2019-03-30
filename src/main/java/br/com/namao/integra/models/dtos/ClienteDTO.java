package br.com.namao.integra.models.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 6165879643673308982L;

    private String nome;

    private String email;

    private String cpf;

    private EnderecoDTO endereco;

    private Set<TelefoneDTO> telefones;

}
