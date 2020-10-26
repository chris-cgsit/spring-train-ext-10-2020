package at.cgsit.training.firstexample.requestsope;

/**
 * Component is created via configuraiton using @Bean Annotation
 * see {@link RandomMessageGeneratorConfig}
 */
public class RandomMessageGenerator {

  private String message;

  private Integer counter ;

  public RandomMessageGenerator(String input) {
    this.message = input;
    this.counter = 0;
  }


  public String getMessage() {
    counter++;
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getCounter() {
    return this.counter;
  }

}
