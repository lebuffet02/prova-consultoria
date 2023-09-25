package br.com.api.prova.external;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.lang.Nullable;


public class ResponseExternal<T> {

    @Schema(
            description = "Indica se a resposta foi um sucesso ou não")
    private String status;

    @Schema(
            description = "Conteúdo da resposta")
    private T body;

    public ResponseExternal() {
        setStatus(getFormat());
    }

    public ResponseExternal(@Nullable T body) {
        setStatus(getFormat());
        this.body = body;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBody(@Nullable T body) {
        this.body = body;
    }

    private String getFormat() {
        return String.format("Retorno da API ".concat(" - ").concat(ResponseStatus.SUCESS.getStatus().toString())
                .concat(" - ").concat(ResponseStatus.SUCESS.getDescription()));
    }
}
