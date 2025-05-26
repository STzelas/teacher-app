package gr.aueb.cf.teacher.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Teachers7Application {

	public static void main(String[] args) {
		SpringApplication.run(Teachers7Application.class, args);
	}

}
