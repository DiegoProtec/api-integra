package br.com.namao.integra.models.entities;

import br.com.namao.integra.models.enums.RoleEnum;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "SEQ_GENERATOR_USUARIO", sequenceName = "SQ_ENDERECO_COSEQUSUARIO", allocationSize = 1, schema = "INTEGRADB")
public class Usuario extends BaseEntity<Long> {

    private static final String ID_USUARIO = "CO_SEQ_USUARIO";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_USUARIO")
    @Column(name = ID_USUARIO)
    private Long id;

    @Column(name = "DS_USUARIO", nullable = false, unique = true)
    private String usuario;

    @Column(name = "DS_SENHA", nullable = false)
    private String senha;

    private String token;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ROLE", nullable = false)
    @Type(type = "pgsql_enum")
    private RoleEnum role;

}
