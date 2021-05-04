package graph;

interface Graph {
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
   * 
   * @return
   */
  void addVertex(Vertex v);

  void addEdge(Vertex v1, Vertex v2, EdgeKind kind);

  boolean isConnected(Vertex v1, Vertex v2);

  boolean isConnected();

  Edge[] getEdges(Vertex v1, Vertex v2);

  Edge[] getEdges();

  Vertex[] getVerdices();

  Edge[] getNeighborEdges(Vertex v);

  String toString();
}