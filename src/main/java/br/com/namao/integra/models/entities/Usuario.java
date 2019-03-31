package br.com.namao.integra.models.entities;

import br.com.namao.integra.models.enums.RoleEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "SEQ_GENERATOR_USUARIO", sequenceName = "SQ_USUARIO_COSEQUSUARIO", allocationSize = 1, schema = "INTEGRADB")
public class Usuario extends BaseEntity<Long> {

    private static final String ID_USUARIO = "CO_SEQ_USUARIO";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_USUARIO")
    @Column(name = ID_USUARIO)
    private Long id;

    @NotNull(message = "O campo usuario é obrigatório.")
    @Size(min = 3, max = 15, message = "Deve conter entre 3 e 16 caracteres")
    @Column(name = "DS_USUARIO", length = 15, nullable = false, unique = true)
    private String usuario;

    @NotNull(message = "O campo senha é obrigatório.")
    @Size(min = 3, max = 15, message = "Deve conter entre 3 e 16 caracteres")
    @Column(name = "DS_SENHA", nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", length = 15, nullable = false)
    private RoleEnum role;

    @Transient
    private Set<String> roles;

}
