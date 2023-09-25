package br.com.api.prova.exception.pessoasException;

public class PessoasException extends RuntimeException {

    public PessoasException() {
        super();
    }

    public PessoasException(String mensagem) {
        super(mensagem);
    }

    public PessoasException(String mensagem, Throwable ex) {
        super(mensagem, ex);
    }
}
