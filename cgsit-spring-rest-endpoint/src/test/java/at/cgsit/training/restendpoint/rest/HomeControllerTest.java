package at.cgsit.training.restendpoint.rest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HomeControllerTest {

 @Autowired
  private HomeController controller;

  @Test
  public void contextLoads() throws Exception {
    assertThat(controller).isNotNull();
  }

  @Test void greeting() {
    String greeting = controller.greeting();
    assertThat(greeting).isNotBlank();
  }

}
