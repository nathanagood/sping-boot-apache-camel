package cloud.nathangood.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * The main configuration class for the application.
 */
@Slf4j
@SpringBootApplication
public class CamelDemoApplication {

	/**
	 * The entry point for the application.
	 * @param args
	 */
	public static void main(String[] args) {
		log.info("Starting...");
		SpringApplication.run(CamelDemoApplication.class, args);
	}
}
