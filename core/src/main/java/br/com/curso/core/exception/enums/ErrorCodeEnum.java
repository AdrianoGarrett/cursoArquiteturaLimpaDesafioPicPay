package br.com.curso.core.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Tax Number invalido","ON-0001"),
    ON0002("Tax Number indisponivel","ON-0002"),
    ON0003("Email indisponivel","ON-0003"),
    ON0004("Houve um erro ao criar o usuario","ON-0004"),

    TR0001("Usuario lojista nao tem a funcao transferencia disponivel","TR-0001"),
    TR0002("Saldo indisponivel","TR-0002"),
    TR0003("Houve um erro na transação","TR-0003"),
    TR0004("Transferencia não autorizada","TR-0004"),

    TRP0001("Pin invalido","TP-0001"),

    WA0001("Carteira não encontrada","WAOOO1"),

    NO0001("Erro ao executar notificação ao usuario","NO0001"),

    ATH0001("Houve um erro na autenticação","ATH0001")

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
