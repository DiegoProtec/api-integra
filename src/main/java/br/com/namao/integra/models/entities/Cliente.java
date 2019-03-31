package br.com.namao.integra.models.entities;

import br.com.namao.integra.models.validators.Cep;
import br.com.namao.integra.models.validators.MinimumOne;
import br.com.namao.integra.models.validators.Nome;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name = "SEQ_GENERATOR_CLIENTE", sequenceName = "SQ_CLIENTE_COSEQCLIENTE", allocationSize = 1, schema = "INTEGRADB")
public class Cliente extends BaseEntity<Long> {

    private static final String ID_CLIENTE = "CO_SEQ_CLIENTE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_CLIENTE")
    @Column(name = ID_CLIENTE)
    private Long id;

    @NotNull(message = "O campo nome é obrigatório.")
    @Nome(message = "Nome inválido.")
    @Column(name = "DS_NOME", length = 100, nullable = false)
    private String nome;

    @NotNull(message = "O campo cpf é obrigatório.")
    @CPF(message = "CPF inválido.")
    @Column(name = "DS_CPF", length = 11, nullable = false)
    private String cpf;

    @NotNull(message = "O campo cep é obrigatório.")
    @Cep(message = "Cep inválido.")
    @Column(name = "DS_CEP", length = 8, nullable = false)
    private String cep;

    @NotNull(message = "O campo estado é obrigatório.")
    @Column(name = "DS_UF", nullable = false)
    private String uf;

    @NotNull(message = "O campo cidade é obrigatório.")
    @Column(name = "DS_CIDADE", nullable = false)
    private String cidade;

    @NotNull(message = "O campo bairro é obrigatório.")
    @Column(name = "DS_BAIRRO", nullable = false)
    private String bairro;

    @NotNull(message = "O campo logradouro é obrigatório.")
    @Column(name = "DS_LOGRADOURO", nullable = false)
    private String logradouro;

    @Column(name = "DS_COMPLEMENTO")
    private String complemento;

    @Builder.Default
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "RL_CLIENTE_TELEFONE", joinColumns = @JoinColumn(name = ID_CLIENTE), inverseJoinColumns = @JoinColumn(name = Telefone.ID_TELEFONE))
    @MinimumOne
    private Set<Telefone> telefones = new HashSet<>();

    @Builder.Default
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "RL_CLIENTE_EMAIL", joinColumns = @JoinColumn(name = ID_CLIENTE), inverseJoinColumns = @JoinColumn(name = Email.ID_EMAIL))
    @MinimumOne
    private Set<Email> emails = new HashSet<>();

}
