package br.com.curso.core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Tax Number invalido","ON-0001"),
    ON0002("Tax Number indisponivel","ON-0002"),
    ON0003("Email indisponivel","ON-0003"),
    TR0001("Usuario lojista nao tem a funcao transferencia disponivel","TR-0001"),
    TR0002("Saldo indisponivel","TR-0002"),
    TRP0001("Pin invalido","TP-0001")
    ;
    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
