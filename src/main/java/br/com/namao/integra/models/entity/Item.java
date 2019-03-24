package br.com.namao.integra.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_ITEM")
public class Item extends BaseEntity<Long> {

    public static final String ID_ITEM = "CO_SEQ_ITEM";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_ITEM")
    @SequenceGenerator(name = "SEQ_GENERATOR_ITEM", sequenceName = "SQ_ITEM_COSEQITEM", allocationSize = 1, schema = "INTEGRADB")
    @Column(name = ID_ITEM)
    private Long id;

    @Column(name = "DS_DESCRICAO")
    private String descricao;

    @Column(name = "NU_PROFUNDIDADE")
    private Double profundidade;

    @Column(name = "NU_LARGURA")
    private Double largura;

    @Column(name = "NU_ALTURA")
    private Double altura;

    @Column(name = "NU_PESO")
    private Double peso;

    @Column(name = "NU_VALOR")
    private Double valor;

    @ManyToMany(mappedBy = "itens")
    private Set<Pacote> pacotes = new HashSet<>();

}
