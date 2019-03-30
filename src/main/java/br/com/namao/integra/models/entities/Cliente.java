package br.com.namao.integra.models.entities;

import br.com.namao.integra.models.validators.NOME;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name = "SEQ_GENERATOR_CLIENTE", sequenceName = "SQ_ENDERECO_COSEQCLIENTE", allocationSize = 1, schema = "INTEGRADB")
public class Cliente extends BaseEntity<Long> {

    private static final String ID_CLIENTE = "CO_SEQ_CLIENTE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_CLIENTE")
    @Column(name = ID_CLIENTE)
    private Long id;

    @NotNull(message = "O campo é obrigatório.")
    @NOME
    @Column(name = "DS_NOME", length = 100, nullable = false)
    private String nome;

    @NotNull(message = "O campo é obrigatório.")
    @Email(message = "Email inválido")
    @Column(name = "DS_EMAIL", nullable = false)
    private String email;

    @NotNull(message = "O campo é obrigatório.")
    @CPF(message = "CPF inválido")
    @Column(name = "DS_CPF", length = 11, nullable = false)
    private String cpf;

    @NotNull(message = "O campo é obrigatório.")
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Endereco endereco;

    @Builder.Default
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "RL_CLIENTE_TELEFONE",
            joinColumns = @JoinColumn(name = ID_CLIENTE),
            inverseJoinColumns = @JoinColumn(name = Telefone.ID_TELEFONE)
    )
    private Set<Telefone> telefones = new HashSet<>();

}
