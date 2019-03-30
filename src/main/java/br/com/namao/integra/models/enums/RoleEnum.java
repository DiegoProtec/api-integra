package br.com.namao.integra.models.enums;

public enum RoleEnum {

    COMUM(1L),
    ADMIN(2L);

    private final Long valor;

    private RoleEnum(Long valor) {
        this.valor = valor;
    }

    public Long getValue() {
        return valor;
    }

}
