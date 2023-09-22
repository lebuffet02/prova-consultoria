package br.com.api.prova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
//@EntityScan(basePackages = "br.com.api.prova.db.entity")
//@EnableJpaRepositories(basePackages = "br.com.api.prova.db.repository")
public class ProvaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvaApplication.class, args);
	}

}
