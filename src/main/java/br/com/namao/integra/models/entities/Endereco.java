package br.com.namao.integra.models.entities;

import br.com.namao.integra.models.validators.CEP;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_ENDERECO")
@SequenceGenerator(name = "SEQ_GENERATOR_ENDERECO", sequenceName = "SQ_ENDERECO_COSEQENDERECO", allocationSize = 1, schema = "INTEGRADB")
public class Endereco extends BaseEntity<Long> {

    private static final String ID_ENDERECO = "CO_SEQ_ENDERECO";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_ENDERECO")
    @Column(name = ID_ENDERECO)
    private Long id;

    @NotNull(message = "O campo é obrigatório.")
    @CEP
    @Column(name = "DS_CEP", length = 8, nullable = false)
    private String cep;

    @Column(name = "DS_COMPLEMENTO")
    private String complemento;

    @NotNull(message = "O campo é obrigatório.")
    @Column(name = "DS_LOGRADOURO", nullable = false)
    private String logradouro;

    @NotNull(message = "O campo é obrigatório.")
    @Column(name = "DS_BAIRRO", nullable = false)
    private String bairro;

    @NotNull(message = "O campo é obrigatório.")
    @Column(name = "DS_CIDADE", nullable = false)
    private String cidade;

    @NotNull(message = "O campo é obrigatório.")
    @Column(name = "DS_UF", nullable = false)
    private String uf;

}
