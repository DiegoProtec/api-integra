package br.com.namao.integra.models.enums;

public enum TipoTelefoneEnum {

    RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial"),
    CELULAR("Celular");

    private final String valor;

    private TipoTelefoneEnum(String valor) {
        this.valor = valor;
    }

    public String getValue() {
        return valor;
    }

}
