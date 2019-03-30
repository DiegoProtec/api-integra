package br.com.namao.integra.models.entities;

import br.com.namao.integra.models.enums.TipoTelefoneEnum;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_TELEFONE")
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
@SequenceGenerator(name = "SEQ_GENERATOR_TELEFONE", sequenceName = "SQ_ENDERECO_COSEQTELEFONE", allocationSize = 1, schema = "INTEGRADB")
public class Telefone extends BaseEntity<Long> {

    public static final String ID_TELEFONE = "CO_SEQ_TELEFONE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_TELEFONE")
    @Column(name = ID_TELEFONE)
    private Long id;

    @Column(name = "DS_TELEFONE", nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "TIPO_TELEFONE", nullable = false)
    @Type(type = "pgsql_enum")
    private TipoTelefoneEnum tipoTelefone;

    @Builder.Default
    @ManyToMany(mappedBy = "telefones")
    private Set<Cliente> clientes = new HashSet<>();

}
