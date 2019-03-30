package br.com.namao.integra.models.entities;

import java.io.Serializable;

@FunctionalInterface
public interface EntityModel extends Serializable {

    Serializable getId();

}
