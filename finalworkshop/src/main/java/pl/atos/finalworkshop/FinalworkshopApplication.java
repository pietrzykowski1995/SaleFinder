package pl.atos.finalworkshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.atos.finalworkshop")
@SpringBootApplication
public class FinalworkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalworkshopApplication.class, args);
	}

}
