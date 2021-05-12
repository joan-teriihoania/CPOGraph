package graphImplementation;

import graph.*;

public class TestGraphImpl {
  private static Vertex v1 = new Vertex();
  private static Vertex v2 = new Vertex();
  private static Vertex v3 = new Vertex();

  public static void main(String[] args){
    IncidenceArrayGraph graph = new IncidenceArrayGraph (10);
    graph.addVertex(v1);
    graph.addVertex(v2);
    graph.addVertex(v3);
    EdgeKind kind = EdgeKind.directed;
    graph.addEdge(v1, v2, kind);
    graph.addEdge(v2, v3, kind);
      
    //graph.addEdge(v2, v3, EdgeKind.undirected);
    testGraph(graph);
    IncidenceArrayGraph.serialize("test.txt", graph);
    IncidenceArrayGraph graph2 = IncidenceArrayGraph.deserialize("test.txt");
    testGraph(graph2);
  }

  // DRY
  private static void testGraph(IncidenceArrayGraph graph){
    
    System.out.println("graph is connected ? (should return false): " + graph.isConnected()); //Should return false 

    //graph.addEdge(v1, v2, kind);
    System.out.println("v1 is connected to v2 ? return true): " + graph.isConnected(v1, v2)); //Should return true 

    System.out.println("v1 is connected to v3 ? : (should return false) " + graph.isConnected(v1, v3)); //Should return false 

    //graph.addEdge(v2, v3, kind);
    System.out.println("v1 is connected to v3 ? (should return true) : " + graph.isConnected(v1, v3)); //Should return true 

    System.out.println("graph is connected ? (should return true): " + graph.isConnected()); //Should return false

    System.out.println(graph);
  }
}