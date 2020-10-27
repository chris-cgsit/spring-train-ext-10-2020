package at.cgsit.training.firstexample.properties;

import at.cgsit.training.firstexample.properties.SingletonPropertyExample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SingletonPropertyExampleTest {

  @Autowired
  SingletonPropertyExample singletonPropertyExample;

  @Test
  void simpleTestComponentEchoTest() {
    String message = singletonPropertyExample.getMessage();
    assertThat(message).isNotNull();
  }

  @SpringBootApplication
  static class TestConfiguration {
  }

}
