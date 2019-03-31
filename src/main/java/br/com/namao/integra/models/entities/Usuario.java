package br.com.namao.integra.models.entities;

import br.com.namao.integra.models.enums.PerfilEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
    @Column(name = "DS_USUARIO", length = 16, nullable = false, unique = true)
    private String usuario;

    @NotNull(message = "O campo senha é obrigatório.")
    @Column(name = "DS_SENHA", length = 300, nullable = false)
    private String senha;

    @Builder.Default
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "TB_PERFIL")
    private Set<Integer> perfis = new HashSet<>();

    public Set<PerfilEnum> getPerfis() {
        return perfis.stream().map(PerfilEnum::toEnum).collect(Collectors.toSet());
    }

}
