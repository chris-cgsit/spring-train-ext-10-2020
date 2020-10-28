package at.cgsit.training.firstexample.appcontext;

import at.cgsit.training.firstexample.qualifier.TestQualifier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestApplicationContext {

    @Autowired
    ApplicationContext springAppContext;

    @Test
    void simpleTestComponentEchoTest() {
        Map<String, TestQualifier> beansOfType = springAppContext.getBeansOfType(TestQualifier.class);
        assertThat(beansOfType).isNotNull();
    }


    @SpringBootApplication
    public static class TestConfiguration {
    }
}
