package graph;
import java.awt.Color;
import java.io.Serializable;

/**
 * A class that models an Edge linking two {@link Vertex}
 * @author Lucas DARIE
*/
public abstract class Edge implements Serializable {
  private static long serialVersionUID = 129348938L;
  private static int lastId = 0;
  private int id;
  private Vertex[] ends;
  private Color col;
  private double value;

  /**
   * Create a default edge
   * 
   * @see Vertex
   */
  public Edge() {
    this(Color.WHITE, 0);
  }

  /**
   * Create an edge
   * 
   * @see Vertex
   * @param col The color of the {@link Edge}
   * @param value The value of the {@link Edge}
   */
  public Edge(Color col, double value) {
    this.id = lastId;
    this.col = col;
    this.ends = new Vertex[2];
    lastId++;
  };

  /**
   * Get the color of the {@link Edge}
   * 
   * @return The color of the {@link Edge}
   */
  public Color getColor() {
    return this.col;
  }

  /**
   * Get the two edges of the {@link Edge}
   * 
   * @return The two enges of the {@link Edge} in an array
   */
  public Vertex[] getEnds() {
    return ends;
  }

  /**
   * Get the ID of the {@link Edge}
   * 
   * @return The ID of the {@link Edge}
   */
  public int getId() {
    return this.id;
  }

  /**
   * Set the two edges array of the {@link Edge}
   * 
   * @param ends The two enges of the {@link Edge} in an array
   */
  public void setEnds(Vertex[] ends) {
    this.ends = ends;
  }

  /**
   * Get a string representation of the {@link Edge} object
   * 
   * @return String of the object
   */
  @Override
  public String toString() {
    return "color: " + this.getColor().toString() + " value: " + this.value + "\nVertex 1: " + this.getEnds()[0]+ "\nVertex 2: " + this.getEnds()[1];
  }
}