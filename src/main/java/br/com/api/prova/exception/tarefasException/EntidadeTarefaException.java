package br.com.api.prova.exception.tarefasException;

public class EntidadeTarefaException extends RuntimeException {

    public EntidadeTarefaException() {
        super();
    }

    public EntidadeTarefaException(String mensagem) {
        super(mensagem);
    }

    public EntidadeTarefaException(String mensagem, Throwable ex) {
        super(mensagem, ex);
    }
}
