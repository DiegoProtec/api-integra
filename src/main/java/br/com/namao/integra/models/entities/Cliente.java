package br.com.namao.integra.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name = "SEQ_GENERATOR_CLIENTE", sequenceName = "SQ_ENDERECO_COSEQCLIENTE", allocationSize = 1, schema = "INTEGRADB")
public class Cliente extends BaseEntity<Long> {

    private static final String ID_CLIENTE = "CO_SEQ_CLIENTE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_CLIENTE")
    @Column(name = ID_CLIENTE)
    private Long id;

    @Column(name = "DS_NOME")
    private String nome;

    @Column(name = "DS_EMAIL")
    private String email;

    @Column(name = "DS_CPF")
    private String cpf;

    @OneToOne
    private Endereco endereco;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "RL_CLIENTE_TELEFONE",
            joinColumns = @JoinColumn(name = ID_CLIENTE),
            inverseJoinColumns = @JoinColumn(name = Telefone.ID_TELEFONE)
    )
    private Set<Telefone> telefones = new HashSet<>();

}
