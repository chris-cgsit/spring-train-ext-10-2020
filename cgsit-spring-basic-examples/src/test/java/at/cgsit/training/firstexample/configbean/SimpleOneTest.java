package at.cgsit.training.firstexample.configbean;

import at.cgsit.training.firstexample.basetest.BaseTest;
import at.cgsit.training.firstexample.component.TestComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleOneTest {

    @Autowired
    Simple simpleTwo;

    // if not specified via qualifier, the bean name ist found with registered bean name
    // if the bean name is not given, the method name of @Bean constructor is taken instead
    // dont use it that way, its unstable if bean constructor names gets renamed
    //@Autowired
    //Simple simpleDontDoThis;

    @Autowired
    @Qualifier("simpleTTT")
    Simple simple;


    @Test
    void simpleOne() {
        Simple component = simple;
        assertThat(component).isNotNull();

        String test_it = component.getString();
        assertThat(test_it).isEqualTo("SimpleOne");
    }


    @Test
    void simpleTwo() {
        Simple component = simpleTwo;
        assertThat(component).isNotNull();

        String test_it = component.getString();
        assertThat(test_it).isEqualTo("SimpleTwo");
    }

    @SpringBootApplication
    public static class SimpleOneTestApp {
    }

}
