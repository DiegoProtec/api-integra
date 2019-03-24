package br.com.namao.integra.models.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class ItemDTO implements Serializable {

    private String descricao;

    private Double profundidade;

    private Double largura;

    private Double altura;

    private Double peso;

    private Double valor;

}
