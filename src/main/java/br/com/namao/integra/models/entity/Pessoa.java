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
@Table(name = "TB_PESSOA")
public class Pessoa extends BaseEntity<Long> {

    public static final String ID_PESSOA = "CO_SEQ_PESSOA";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_PESSOA")
    @SequenceGenerator(name = "SEQ_GENERATOR_PESSOA", sequenceName = "SQ_PESSOA_COSEQPESSOA", allocationSize = 1, schema = "INTEGRADB")
    @Column(name = ID_PESSOA)
    private Long id;

    @Column(name = "DS_CPF")
    private String cpf;

    @Column(name = "DS_NOME")
    private String nome;

    @Column(name = "DS_TELEFONE")
    private String telefone;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "RL_PESSOA_ENDERECO",
            joinColumns = @JoinColumn(name = ID_PESSOA),
            inverseJoinColumns = @JoinColumn(name = Endereco.ID_ENDERECO)
    )
    private Set<Endereco> enderecos = new HashSet<>();

}