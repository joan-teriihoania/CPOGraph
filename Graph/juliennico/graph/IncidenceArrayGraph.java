package graph;
import java.lang.Math;

public abstract class IncidenceArrayGraph implements Graph {
  private Vertex[] vertices;
  private Edge[] edges;
  private int[][] incidenceArray;

  public IncidenceArrayGraph(int n){
    int m = Math.ceil(n*(n-1)/2);
    this.vertices = new Vertex[n];
    this.edges = new Edge[m];
    this.incidenceArray = new int[n][m];
  }

  /**
   * Retrieve the number of {@link graph.Vertex}
   * 
   * @return Amount of {@link Vertex} in {@link Graph}
   */
  public int nbOfVertices(){
    return vertices.length;
  }

  /**
   * Retrieve the number of {@link Edge}
   * 
   * @return Amount of {@link Edge} in {@link Graph}
   */
  public int nbOfEdges(){
    return this.edges.length;
  }

  /**
   * Add a {@link Vertex} in {@link Graph}
   */
  public void addVertex(Vertex v){
    for(int i =0;i<vertices.length;i++){
      vertices[i] = new Vertex();
    }
  }

  /**
   * Add a {@link Edge} in {@link Graph}
   * @param v1 A {@link Vertex} at one end of the {@link Edge} wanted
   * @param v2 Another {@link Vertex} at one end of the {@link Edge} wanted
   * @Param kind A {@link EdgeKind} to specified whether the {@link Edge} is {@link DirectedEdge} or {@link UndirectedEdge}
  */
  public void addEdge(Vertex v1, Vertex v2, EdgeKind kind){
    
  }

  /**
   * Retrieve whether two {@link Vertex} are connected or not
   * @param v1 A {@link Vertex} in {@link Graph}
   * @param v2 Another {@link Vertex} in {@link Graph}
   * @return True if the two {@link Vertex} are connected directly or indirectly via a {@link Edge}
  */
  public boolean isConnected(Vertex v1, Vertex v2){

  }

  /**
    * Retrieve whether {@link Graph} is connected or not
    * @return True if all {@link Vertex} in {@link Graph} are connected directly or indirectly via {@link Edge}
  */
  public boolean isConnected(){

  }

  /**
   * Retrieve the {@link Edge} connecting two {@link Vertex}
   * @param v1 A {@link Vertex} in {@link Graph}
   * @param v2 Another {@link Vertex} in {@link Graph}
   * @return List of {@link Edge}
  */
  public Edge[] getEdges(Vertex v1, Vertex v2){

  }

  /**
    * Retrieve all {@link Edge} in {@link Graph}
    * @return Amount of {@link Edge}
  */
  public Edge[] getEdges(){

  }

  /**
    * Retrieve all {@link Vertex} in {@link Graph}
    * @return Amount of {@link Vertex}
  */
  public Vertex[] getVerdices(){

  }

  /**
    * Retrieve all {@link Edge} in {@link Graph} connected to {@link Vertex}
    * @return List of {@link Edge}
  */
  public Edge[] getNeighborEdges(Vertex v){

  }
  
  @Override
  String toString();
}