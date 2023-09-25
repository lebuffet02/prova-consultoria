package br.com.api.prova.exception.regraNegocioException;

public class RegraNegocioException extends RuntimeException {

    public RegraNegocioException() {
        super();
    }

    public RegraNegocioException(String mensagem) {
        super(mensagem);
    }

    public RegraNegocioException(String mensagem, Throwable ex) {
        super(mensagem, ex);
    }
}
