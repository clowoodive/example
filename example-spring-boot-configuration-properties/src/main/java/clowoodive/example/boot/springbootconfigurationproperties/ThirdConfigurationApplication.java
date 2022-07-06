package clowoodive.example.boot.springbootconfigurationproperties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class ThirdConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdConfigurationApplication.class, args);
	}

	@Autowired
	private ThirdConfig thirdConfig;

	@Bean
	public ApplicationRunner thirdApplicationRunner() {
		return args -> {
			log.info("third: " + thirdConfig.getMyName());
		};
	}

}
