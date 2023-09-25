package br.com.api.prova.exception.departamentoException;

public class DepartamentoException extends RuntimeException {

    public DepartamentoException() {
        super();
    }

    public DepartamentoException(String mensagem) {
        super(mensagem);
    }

    public DepartamentoException(String mensagem, Throwable ex) {
        super(mensagem, ex);
    }
}
