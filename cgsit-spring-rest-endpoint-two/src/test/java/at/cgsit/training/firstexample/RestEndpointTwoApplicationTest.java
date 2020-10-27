package at.cgsit.training.firstexample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestEndpointTwoApplicationTest {

    @Test
    void contextLoads() {
        assertThat("test").isNotNull();
    }

}

