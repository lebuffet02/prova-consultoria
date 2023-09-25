package br.com.api.prova.exception;

import br.com.api.prova.exception.departamentoException.DepartamentoException;
import br.com.api.prova.exception.pessoasException.EntidadePessoasException;
import br.com.api.prova.exception.pessoasException.PessoasException;
import br.com.api.prova.exception.tarefasException.EntidadeTarefaException;
import br.com.api.prova.exception.tarefasException.TarefasException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {


    @ExceptionHandler(PessoasException.class)
    public ResponseEntity<Object> pessoasErrorException(PessoasException e) {
        return new ResponseEntity<>(getMap(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntidadePessoasException.class)
    public ResponseEntity<Object> entidadeErrorException(PessoasException e) {
        return new ResponseEntity<>(getMap(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TarefasException.class)
    public ResponseEntity<Object> tarefasErrorException(TarefasException e) {
        return new ResponseEntity<>(getMap(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntidadeTarefaException.class)
    public ResponseEntity<Object> entidadeErrorException(EntidadeTarefaException e) {
        return new ResponseEntity<>(getMap(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepartamentoException.class)
    public ResponseEntity<Object> departamentoException(DepartamentoException e) {
        return new ResponseEntity<>(getMap(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    private Map<String, Object> getMap(String e) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("message", e);
        return body;
    }
}
