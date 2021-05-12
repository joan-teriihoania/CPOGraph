package graph;
import java.awt.Color;
import java.io.Serializable;

/**
 * A class that models a Vertex that can be linked with another {@link Vertex} using {@link Edge} in a {@link Graph}
 * @author Lucas DARIE
*/
public class Vertex implements Serializable {
  private static long serialVersionUID = 129348938L;
  private static int lastId = 0;
  private int id;
  private Object info;
  private Color col;

  /**
   * Create a default {@link Vertex}
   */
  public Vertex() {
    this(new String("Vide"), Color.WHITE);
  }

  /**
   * Create an edge
   * 
   * @param info  The info of the {@link Vertex}
   * @param col The color of the {@link Vertex}
   */
  public Vertex(Object info, Color col) {
    this.id = lastId;
    this.info = info;
    this.col = col;
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
  public Color getColor() {
    return this.col;
  }

  /**
   * Get the ID of the {@link Vertex}
   * 
   * @return The ID of the {@link Vertex}
   */
  public int getId() {
    return this.id;
  }
  
  /**
   * Set the color of the {@link Vertex}
   * 
   * @param col The color of the {@link Vertex}
   */
  public void setColor(Color col) {
    this.col = col;
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
    return "color: " + this.getColor().toString() + " info: " + this.getInfo().toString();
  }
}