package clowoodive.example.boot.springbootconfigurationproperties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
@ConfigurationPropertiesScan
//@ConfigurationPropertiesScan("clowoodive.example.boot.springbootconfigurationproperties")
//@ConfigurationPropertiesScan({"clowoodive.example.boot.springbootconfigurationproperties", "clowoodive.example.boot.springbootconfigurationproperties
// .config"})
public class FourthConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FourthConfigurationApplication.class, args);
	}

	@Autowired
	private FourthConfig fourthConfig;

	@Bean
	public ApplicationRunner fourthApplicationRunner() {
		return args -> {
			log.info("fourth: " + fourthConfig.getMyName());
		};
	}
}
