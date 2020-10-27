package at.cgsit.training.firstexample.qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class NormalTestQualifierComponent implements TestQualifier {

  @Override public String echo(String echo) {
    return "NormalTestQualifierComponent";
  }

}
