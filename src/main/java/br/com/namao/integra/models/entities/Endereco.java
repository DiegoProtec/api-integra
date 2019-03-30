package br.com.namao.integra.models.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "TB_ENDERECO")
@SequenceGenerator(name = "SEQ_GENERATOR_ENDERECO", sequenceName = "SQ_ENDERECO_COSEQENDERECO", allocationSize = 1, schema = "INTEGRADB")
public class Endereco extends BaseEntity<Long> {

    private static final String ID_ENDERECO = "CO_SEQ_ENDERECO";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR_CLIENTE")
    @Column(name = ID_ENDERECO)
    private Long id;

    @Column(name = "DS_CEP", nullable = false)
    private String cep;

    @Column(name = "DS_COMPLEMENTO")
    private String complemento;

    @Column(name = "DS_LOGRADOURO", nullable = false)
    private String logradouro;

    @Column(name = "DS_BAIRRO", nullable = false)
    private String bairro;

    @Column(name = "DS_CIDADE", nullable = false)
    private String cidade;

    @Column(name = "DS_UF", nullable = false)
    private String uf;

}
