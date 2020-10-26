package at.cgsit.training.firstexample.requestsope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

// Should be a Configuration
@Configuration
public class GlobalCounterConfig {

  @Bean
  @ApplicationScope
  public GlobalCounter globalCounter() {
   return new GlobalCounter();
  }

}
