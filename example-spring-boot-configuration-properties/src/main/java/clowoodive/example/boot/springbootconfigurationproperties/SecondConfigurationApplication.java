package clowoodive.example.boot.springbootconfigurationproperties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(SecondConfig.class)
public class SecondConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondConfigurationApplication.class, args);
	}

	@Autowired
	private SecondConfig secondConfig;

	@Bean
	public ApplicationRunner secondApplicationRunner() {
		return args -> {
			log.info("second: " + secondConfig.getMyName());
		};
	}

}
