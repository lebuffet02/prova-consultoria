package br.com.api.prova.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Teste a ser realizado",
        description = "Prova-Consultoria",
        version = "1.0",
        contact = @Contact(
                name = "Lucas Buffet",
                email = "lebuffet02@gmail.com",
                url = "https://github.com/lebuffet02/prova-consultoria"
        ),
        license = @License(
                name = "Apache 2.0"))
)
public class SwaggerConfig implements WebMvcConfigurer {}
