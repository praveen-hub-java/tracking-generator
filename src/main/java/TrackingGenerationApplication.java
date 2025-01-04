import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("com.tracking")
@EnableJpaRepositories(basePackages = "com.tracking.persistancy")
@EntityScan("com.tracking.model")
public class TrackingGenerationApplication {
	public static void main(String[] args) {
		SpringApplication.run(TrackingGenerationApplication.class, args);
	}
}
