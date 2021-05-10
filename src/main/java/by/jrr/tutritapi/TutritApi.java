package by.jrr.tutritapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableDiscoveryClient
@SpringBootApplication
//@EnableFeignClients
@EnableSwagger2
public class TutritApi {

	public static void main(String[] args) {
		SpringApplication.run(TutritApi.class, args);
	}

}
