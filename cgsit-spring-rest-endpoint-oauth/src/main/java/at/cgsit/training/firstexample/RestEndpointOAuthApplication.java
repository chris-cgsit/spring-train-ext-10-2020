package at.cgsit.training.firstexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="at.cgsit")
public class RestEndpointOAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestEndpointOAuthApplication.class, args);
  }

}
