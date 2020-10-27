package at.cgsit.training.firstexample.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesSample {

  @Value("${myapp.myValue}")
  private String myValue;

  public PropertiesSample() {
  }

  public String getMyValue() {
    return this.myValue;
  }
}
