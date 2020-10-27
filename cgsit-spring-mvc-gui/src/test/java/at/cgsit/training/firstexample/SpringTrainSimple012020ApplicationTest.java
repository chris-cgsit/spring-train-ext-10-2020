package at.cgsit.training.firstexample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringTrainSimple012020ApplicationTest {

    @Test
    void contextLoads() {
        assertThat("test").isNotNull();
    }

}
