package br.com.namao.integra.models.entities;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.*;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_EMAIL")
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
@SequenceGenerator(name = "SEQ_GENERATOR_EMAIL", sequenceName = "SQ_EMAIL_COSEQEMAIL", allocationSize = 1, schema = "INTEGRADB")
public class EmailEntity extends BaseEntity<Long> {

    public static final String ID_EMAIL = "CO_SEQ_EMAIL";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_EMAIL")
    @Column(name = ID_EMAIL)
    private Long id;

    @NotNull(message = "O campo é obrigatório.")
    @Email(message = "Email inválido.")
    @Column(name = "DS_EMAIL", nullable = false)
    private String email;

    @Builder.Default
    @ManyToMany(mappedBy = "emails")
    private Set<Cliente> clientes = new HashSet<>();

}
