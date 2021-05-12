package graphImplementation.exceptions;

public class GraphOverflowException extends RuntimeException {
  
  public GraphOverflowException() {
      super();
  }
  public GraphOverflowException(String s) {
      super(s);
  }
  public GraphOverflowException(String s, Throwable throwable) {
      super(s, throwable);
  }
  public GraphOverflowException(Throwable throwable) {
      super(throwable);
  }
}