package at.cgsit.training.firstexample.requestsope;

public class GlobalCounter {

  private Integer counter ;

  public GlobalCounter(){
    this.counter=0;
  }

  public Integer getCounter() {
    this.counter++;
    return this.counter;
  }

}
