package br.com.namao.integra.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_ENDERECO")
public class Endereco extends BaseEntity<Long> {

    public static final String ID_ENDERECO = "COD_ENDERECO";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ID_ENDERECO)
    private Long id;

    @Column(name = "DS_RUA")
    private String rua;

    @Column(name = "DS_COMPLEMENTO")
    private String complemento;

    @Column(name = "DS_NUMERO")
    private String numero;

    @Column(name = "DS_BAIRRO")
    private String bairro;

    @Column(name = "DS_CIDADE")
    private String cidade;

    @Column(name = "DS_ESTADO")
    private String estado;

    @ManyToMany(mappedBy = "enderecos")
    private Set<Pessoa> pessoas = new HashSet<>();

}
