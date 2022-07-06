package clowoodive.example.boot.springbootconfigurationproperties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class FirstConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstConfigurationApplication.class, args);
	}

	@Autowired
	private FirstConfig firstConfig;

	@Bean
	public ApplicationRunner firstApplicationRunner() {
		return args -> {
			log.info("first: " + firstConfig.getMyName());
		};
	}

}
