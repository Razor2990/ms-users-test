package com.liverpool.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI optionsOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Api de Usuarios Liverpool-Examen Tecnico")
						.version("1.0")
						.summary("Para mayor comunicación comunicarse a ... :)")
						.description("Documentación de los endpoind del microservicio de USUARIOS.")
						.contact(new Contact()
								.name("Erick Josué Guerrero Rodríguez")
								.email("josue_bat@outlook.com")
								)
						.license(new License().name("Es de mi autoría pero lo pueden usar como referencia a quién lo desee.")));
	}
}
