package at.cgsit.training.firstexample.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {

  Logger logger = LoggerFactory.getLogger(TestComponent.class);

  public String echo( String echo) {
    logger.info("TestComponent log it {}", echo);
    return echo;
  }

}
