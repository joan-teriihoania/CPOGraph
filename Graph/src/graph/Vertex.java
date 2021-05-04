package graph;
/**
 * A class that models a Vertex that can be linked with another {@link Vertex} using {@link Edge} in a {@link Graph}
*/
public class Vertex {
  private static int lastId = 0;
  private int id;
  private Object info;
  private String color;

  /**
   * Create a default {@link Vertex}
   */
  public Vertex() {
    this(null, "white");
  }

  /**
   * Create an edge
   * 
   * @param info  The info of the {@link Vertex}
   * @param color The color of the {@link Vertex}
   */
  public Vertex(Object info, String color) {
    this.id = lastId;
    this.info = info;
    this.color = color;
    lastId++;
  };
  /**
   * Get the info of the {@link Vertex}
   * 
   * @return The info of the {@link Vertex}
   */
  public Object getInfo() {
    return this.info;
  }
  /**
   * Get the color of the {@link Vertex}
   * 
   * @return The color of the {@link Vertex}
   */
  public String getColor() {
    return this.color;
  }
  
  /**
   * Set the color of the {@link Vertex}
   * 
   * @param color The color of the {@link Vertex}
   */
  public void setColor(String color) {
    this.color = color;
  }
  /**
   * Set the info of the {@link Vertex}
   * 
   * @param info The info of the {@link Vertex}
   */
  public void setInfo(Object info) {
    this.info = info;
  }

  /**
   * Get a string representation of the {@link Vertex} object
   * 
   * @return String of the object
   */
  @Override
  public String toString() {
    return "color: " + this.getColor() + " info: " + this.getInfo();
  }
}