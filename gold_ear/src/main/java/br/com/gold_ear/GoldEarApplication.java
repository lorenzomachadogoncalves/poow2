package br.com.gold_ear;

import br.com.gold_ear.model.usuario.Usuario;
import br.com.gold_ear.model.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				title = "API - Exemplo",
				version = "1.0",
				description = "Documentação de API - Exemplo",
				contact = @Contact(name = "Sup", email = "suport@example.com")
		)
)

@SpringBootApplication
public class GoldEarApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoldEarApplication.class, args);
	}
//	@Bean
//	public CommandLineRunner init(UsuarioRepository uRepository) {
//		return (args)->{
//			uRepository.save(new Usuario("ultraman", "ultraman@gmail.com", "0444444", "1234"));
//		};
//	}
}
