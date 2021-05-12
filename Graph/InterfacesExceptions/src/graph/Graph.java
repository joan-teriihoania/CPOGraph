package graph;

/**
 * Models a Graph with {@link Vertex} and {@link Edge} linking them
 * @author Joan TERIIHOANIA
*/
public interface Graph {
  /**
   * Retrieve the number of {@link graph.Vertex}
   * 
   * @return Amount of {@link Vertex} in {@link Graph}
   */
  int nbOfVertices();

  /**
   * Retrieve the number of {@link Edge}
   * 
   * @return Amount of {@link Edge} in {@link Graph}
   */
  int nbOfEdges();

  /**
   * Add a {@link Vertex} in {@link Graph}
   */
  void addVertex(Vertex v);

  /**
   * Add a {@link Edge} in {@link Graph}
   * @param v1 A {@link Vertex} at one end of the {@link Edge} wanted
   * @param v2 Another {@link Vertex} at one end of the {@link Edge} wanted
   * @Param kind A {@link EdgeKind} to specified whether the {@link Edge} is {@link DirectedEdge} or {@link UndirectedEdge}
  */
  void addEdge(Vertex v1, Vertex v2, EdgeKind kind);

  /**
   * Retrieve whether two {@link Vertex} are connected or not
   * @param v1 A {@link Vertex} in {@link Graph}
   * @param v2 Another {@link Vertex} in {@link Graph}
   * @return True if the two {@link Vertex} are connected directly or indirectly via a {@link Edge}
  */
  boolean isConnected(Vertex v1, Vertex v2);

  /**
    * Retrieve whether {@link Graph} is connected or not
    * @return True if all {@link Vertex} in {@link Graph} are connected directly or indirectly via {@link Edge}
  */
  boolean isConnected();

  /**
   * Retrieve the {@link Edge} connecting two {@link Vertex}
   * @param v1 A {@link Vertex} in {@link Graph}
   * @param v2 Another {@link Vertex} in {@link Graph}
   * @return List of {@link Edge}
  */
  Edge[] getEdges(Vertex v1, Vertex v2);

  /**
    * Retrieve all {@link Edge} in {@link Graph}
    * @return Amount of {@link Edge}
  */
  Edge[] getEdges();

  /**
    * Retrieve all {@link Vertex} in {@link Graph}
    * @return Amount of {@link Vertex}
  */
  Vertex[] getVerdices();

  /**
    * Retrieve all {@link Edge} in {@link Graph} connected to {@link Vertex}
    * @return List of {@link Edge}
  */
  Edge[] getNeighborEdges(Vertex v);
  
  @Override
  String toString();
}