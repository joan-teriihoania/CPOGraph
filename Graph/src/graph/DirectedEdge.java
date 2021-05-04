package graph;

public class DirectedEdge extends Edge {
  private int source; // 0 or 1

  /**
   * Create a DirectedEdge
   * @param source The source {@link graph.Vertex} of the edge
   * @param sink The sink {@link graph.Vertex} of the edge
  */
  public DirectedEdge(Vertex source, Vertex sink){
    this.sources = 0;
    Vertex[] tmp = new Vertex[2];
    tmp[0] = source;
    tmp[1] = sink;
    super.setEnds(tmp);
  }

  /**
   * Retrieve the source {@link graph.Vertex} of a DirectedEdge
   * @return The source {@link graph.Vertex}
  */
  public Vertex getSource(){
    return super.getEnds()[this.source];
  }

  /**
   * Retrieve the sink {@link graph.Vertex} of a DirectedEdge
   * @return The sink {@link graph.Vertex}
  */
  public Vertex getSink(){
    if(this.source == 0){return super.getEnds()[1];}
    else{return super.getEnds()[0];}
  }

  /**
   * Get a string representation of the DirectedEdge object
   * @return String of the object
  */
  public String toString(){
    return "";
  }
}