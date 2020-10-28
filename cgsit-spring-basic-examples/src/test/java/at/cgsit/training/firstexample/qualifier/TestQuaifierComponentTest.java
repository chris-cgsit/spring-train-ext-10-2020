package at.cgsit.training.firstexample.qualifier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TestQuaifierComponentTest {

    @Autowired
    @Qualifier("testQualifierComponent")
    TestQualifier testComponent;

    @Test
    void simpleTestComponentEchoTest() {
        assertThat(testComponent).isNotNull();
        String test_it = testComponent.echo("dddd");
        // test qualifier will simply return "TestQuaifierComponent"
        assertThat(test_it).isEqualTo("TestQuaifierComponent");
    }


    @SpringBootApplication
    public static class TestConfiguration {
    }
}
