package br.com.namao.integra.models.mappers;

import java.util.List;

public interface BaseMapper<E, D> {

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDto(List<E> entitys);

    List<E> toEntity(List<D> dtos);

}
