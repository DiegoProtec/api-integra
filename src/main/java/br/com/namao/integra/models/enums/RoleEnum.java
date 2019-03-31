package br.com.namao.integra.models.enums;

public enum RoleEnum {

    COMUM("COMUM"),
    ADMIN("ADMIN");

    private final String valor;

    private RoleEnum(String valor) {
        this.valor = valor;
    }

    public String getValue() {
        return valor;
    }

}
