package br.com.namao.integra.models.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class EmailDTO implements Serializable {

    private static final long serialVersionUID = 1591126882924703162L;

    private String email;

}
