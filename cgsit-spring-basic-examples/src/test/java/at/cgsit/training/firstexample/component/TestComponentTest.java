package at.cgsit.training.firstexample.component;

import at.cgsit.training.firstexample.basetest.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TestComponentTest extends BaseTest {

  @Autowired
  TestComponent testComponent;

  @Test
  void simpleTestComponentEchoTest() {
    assertThat(testComponent).isNotNull();
    String test_it = testComponent.echo("test it");
    assertThat(test_it).isEqualTo("test it");
  }

  @SpringBootApplication
  public static class TestConfiguration {
  }
}
