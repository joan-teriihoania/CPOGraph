package graph;

interface Graph {
  int nbOfVertices();
  int nbOfEdges();
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