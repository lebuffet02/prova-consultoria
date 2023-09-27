package br.com.api.prova.controller.health;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "healthy", produces = {"aplication/json"})
@Tag(name = "Healthy Controller", description = "Verificar se o serviço está no ar")
public class HealthyController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço saudável"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @GetMapping()
    public String healthy() {
        return "Ok";
    }
}




