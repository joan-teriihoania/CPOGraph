package graph;

/**
 * A subclass of Edge that models an edge with no direction
 * @author Joan TERIIHOANIA
*/
public class UndirectedEdge extends Edge {
  public UndirectedEdge(Vertex[] ends) {
    super.setEnds(ends);
  }

  /**
   * Get a string representation of the {@link Edge} object
   * 
   * @return String of the object
   */
  @Override
  public String toString() {
    return "";
  }
}