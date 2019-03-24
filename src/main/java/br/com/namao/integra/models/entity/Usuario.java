package br.com.namao.integra.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_USUARIO")
public class Usuario extends BaseEntity<Long> {

    public static final String ID_USUARIO = "CO_SEQ_USUARIO";

    @Id
    @Column(name = ID_USUARIO)
    private Long id;

    @Column(name = "DS_EMAIL")
    private String email;

    @Column(name = "DS_SENHA")
    private String senha;

    @OneToOne
    @JoinColumn
    @MapsId
    private Pessoa pessoa;

}
