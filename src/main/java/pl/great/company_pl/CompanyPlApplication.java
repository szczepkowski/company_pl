package pl.great.company_pl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CompanyPlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyPlApplication.class, args);
	}

}
