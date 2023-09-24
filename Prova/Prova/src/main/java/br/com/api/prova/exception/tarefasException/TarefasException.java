package br.com.api.prova.exception.tarefasException;

public class TarefasException extends RuntimeException {

    public TarefasException() {
        super();
    }

    public TarefasException(String mensagem) {
        super(mensagem);
    }

    public TarefasException(String mensagem, Throwable ex) {
        super(mensagem, ex);
    }
}
