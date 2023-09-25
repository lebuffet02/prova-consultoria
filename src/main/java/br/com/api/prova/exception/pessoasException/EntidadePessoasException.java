package br.com.api.prova.exception.pessoasException;

public class EntidadePessoasException extends RuntimeException {

    public EntidadePessoasException() {
        super();
    }

    public EntidadePessoasException(String mensagem) {
        super(mensagem);
    }

    public EntidadePessoasException(String mensagem, Throwable ex) {
        super(mensagem, ex);
    }
}
