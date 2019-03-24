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
@Table(name = "TB_PACOTE")
public class Pacote extends BaseEntity<Long> {

    public static final String ID_PACOTE = "COD_PACOTE";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ID_PACOTE)
    private Long id;

    @Column(name = "NU_VALOR")
    private Double valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_REMETENTE", referencedColumnName = Pessoa.ID_PESSOA)
    private Pessoa remetente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_DESTINATARIO", referencedColumnName = Pessoa.ID_PESSOA)
    private Pessoa destinatario;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "RL_PACOTE_ITEM",
            joinColumns = @JoinColumn(name = ID_PACOTE),
            inverseJoinColumns = @JoinColumn(name = Item.ID_ITEM)
    )
    private Set<Item> itens = new HashSet<>();

}
