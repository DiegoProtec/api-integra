package br.com.namao.integra.models.entities;

import br.com.namao.integra.models.enums.TipoTelefoneEnum;
import lombok.*;

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
@Table(name = "TB_TELEFONE")
@SequenceGenerator(name = "SEQ_GENERATOR_TELEFONE", sequenceName = "SQ_TELEFONE_COSEQTELEFONE", allocationSize = 1, schema = "INTEGRADB")
@br.com.namao.integra.models.validators.Telefone
public class Telefone extends BaseEntity<Long> {

    public static final String ID_TELEFONE = "CO_SEQ_TELEFONE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_TELEFONE")
    @Column(name = ID_TELEFONE)
    private Long id;

    @NotNull(message = "O campo telefone é obrigatório.")
    @Column(name = "DS_TELEFONE", length = 11, nullable = false)
    private String telefone;

    @NotNull(message = "O campo tipo de telefone é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_TELEFONE", nullable = false)
    private TipoTelefoneEnum tipoTelefone;

    @Builder.Default
    @ManyToMany(mappedBy = "telefones")
    private Set<Cliente> clientes = new HashSet<>();

}
