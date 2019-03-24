package br.com.namao.integra.models.entity;

import java.io.Serializable;

@FunctionalInterface
public interface EntityModel extends Serializable {

    Serializable getId();

}
