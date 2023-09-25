package br.com.api.prova.external;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(
        shape = JsonFormat.Shape.OBJECT
)
public enum ResponseStatus {

    SUCESS(200, "Requisição foi realizada com sucesso."),
    BAD_REQUEST(400, "Requisição não efetuada de maneira adequada."),
    UNAUTHORIZED(401, "Não autorizado."),
    FORBIDDEN(403, "Sem permissão."),
    NOT_FOUND(404, "Não encontrado."),
    INTERNAL_SERVER_ERROR(500, "Não foi possível realizar a solicitação.");

    private final Integer status;
    private final String description;

    ResponseStatus(Integer status, String description) {
        this.status = status;
        this.description = description;
    }
}
