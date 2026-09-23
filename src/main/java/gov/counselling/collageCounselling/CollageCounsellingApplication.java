package gov.counselling.collagecounselling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class CollageCounsellingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollageCounsellingApplication.class, args);
	}

}
