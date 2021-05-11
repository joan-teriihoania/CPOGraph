package graphImplementation;

import graph.*;
import java.lang.Math;
import java.awt.Color;

public class IncidenceArrayGraph implements Graph {
  private Vertex[] vertices;
  private Edge[] edges;
  private Edge[][] incidenceArray;
  private EdgeKind kind;

  public IncidenceArrayGraph(int n) throws IllegalArgumentException {
    if(n >= Integer.MAX_VALUE/2){
      throw new IllegalArgumentException("Integer overflow may occur");
    }
    
    if(n <= 0){
      throw new IllegalArgumentException("Negative or zero array size");
    }

    // int m = (int)Math.ceil(n*(n-1)/2);
    int m = 2*n;

    if(m >= Integer.MAX_VALUE - 5){
      throw new IllegalArgumentException("Vertices amount exceeds max array size");
    }

    this.vertices = new Vertex[n];
    this.edges = new Edge[m];
    this.incidenceArray = new Edge[n][m];
  }

  private int nbMaxOfVertices(){
    return vertices.length;
  }

  private int nbMaxOfEdges(){
    return this.edges.length;
  }

  @Override
  public int nbOfVertices(){
    int count = 0;
    for (int i = 0; i < this.vertices.length; i++) {
      if(this.vertices[i] != null){
        count++;
      }
    }
    return count;
  }

  @Override
  public int nbOfEdges(){
    int count = 0;
    for (int i = 0; i < this.edges.length; i++) {
      if(this.edges[i] != null){
        count++;
      }
    }
    return count;
  }

  @Override
  public void addVertex(Vertex v){
    int i = 0;
    while(i<this.vertices.length){
      if (this.vertices[i] == null){
        this.vertices[i] = v;
        break;
      }
      i++;
    }
  }
  /**
   * Returns the EdgeKind used by ALL the edges of this graph 
  */
  private boolean isDirected(){
    return (this.kind == EdgeKind.directed);
  }

  private boolean isUndirected(){
    return !isDirected();
  }
  

  public void addEdge(Vertex v1, Vertex v2, EdgeKind kind) {
    if(nbOfEdges() > 0){
      switch(kind){
        case directed:
          if(!isDirected()){
            throw new IllegalArgumentException("You cannot add DirectedEdge to a graph with UndirectedEdge");
          }
          break;
        case undirected:
          if(!isUndirected()){
            throw new IllegalArgumentException("You cannot add UndirectedEdge to a graph with DirectedEdge");
          }
          break;
      }
    }

    this.kind = kind;

    Edge e;
    Vertex[] tmp = new Vertex [2]; 
    tmp [0] = v1;
    tmp [1] = v2;


    if(v1.getId() >= this.incidenceArray.length || v2.getId() >= this.incidenceArray.length){
      throw new IllegalArgumentException("Vertex id exceeds incidenceArray size");
    }

    switch(kind){
      case directed:
        e = new DirectedEdge(0, Color.WHITE, tmp, 0, 0);
        if(e.getId() >= this.edges.length){
          throw new IllegalArgumentException("DirectedEdge id exceeds edges array size");
        }
        edges[e.getId()] = e;
        break;
      default: // undirected
        e = new UndirectedEdge(0, Color.WHITE, tmp, 0);
        if(e.getId() >= this.edges.length){
          throw new IllegalArgumentException("DirectedEdge id exceeds edges array size");
        }
        edges[e.getId()] = e;
        break;
    }

    int i = 0;
    while (incidenceArray[v1.getId()][i] != null) {
      i ++;
    }
    incidenceArray[v1.getId()][i] = e;

    i = 0; 
    while (incidenceArray[v2.getId()][i] != null) {
      i ++;
    }
    incidenceArray[v2.getId()][i] = e;
  }
  
  public boolean isConnected(Vertex v1, Vertex v2){
    if(v1 == v2){
        return true;
    }

    int etat[] = new int[this.vertices.length];
    for(int i = 0; i<this.vertices.length ; i++){
        etat[i] = 0;
    }
    boolean found = false;    
    int current = v1.getId();
    etat[current] = 1;
    
    
    if(v1.getId() >= etat.length || v2.getId() >= etat.length || v1.getId() >= this.incidenceArray.length || v2.getId() >= this.incidenceArray.length || current >= this.vertices.length){
      throw new IllegalArgumentException("Vertex id exceeds incidenceArray size");
    }

    while(etat[v2.getId()] != 1 && current != -1){
      int i = 0;
      while(i<this.vertices.length && this.incidenceArray[current][i] != null){
        Vertex v = getOtherVertex(this.incidenceArray[current][i], this.vertices[current]);
        if(etat[v.getId()] == 0){
          etat[v.getId()] = 1;
        }
        i++;
      }
      etat[current] = 2;

      //Find the first with a 1;
      boolean found1 = false;
      int j = 0;
      current = -1;
      while(j < etat.length && !found1){
        if(etat[j] == 1){
          current = j;
          found1 = true;
        }
        j++;
      }
    }
    return etat[v2.getId()] == 1; 
  }

  public boolean isConnected(){
    boolean res = true;
    int i=1;
    while(i<this.vertices.length && res){
      if(this.vertices[i] != null){
        res = this.isConnected(this.vertices[0], this.vertices[i]);
      }
      i++;
    }

    return res;
  }


  //Return the other Vertex of a Edge
  private Vertex getOtherVertex (Edge e, Vertex v) {
      if (e.getEnds()[0].getId() == v.getId()) {
          return e.getEnds()[1];
      }
      
      return e.getEnds()[0];
  }

  @Override
  public Edge[] getEdges(Vertex v1, Vertex v2) {
    Edge[] neighbourEdges  = new Edge[this.vertices.length];
    Vertex [] tmp;
    
    if(v1.getId() >= this.incidenceArray.length || v2.getId() >= this.incidenceArray.length){
      throw new IllegalArgumentException("Vertex id exceeds incidenceArray size");
    }

    int v1ID = v1.getId(), v2ID = v2.getId();
    
    int i = 0; 
    for (Edge neigh : this.incidenceArray[v1ID]) { //We check in v1 neighbour
        if (v2ID == this.getOtherVertex(neigh, v1).getId()) {
          neighbourEdges[i] = neigh;
          i ++;
        }
    }
    return neighbourEdges;
  }

  @Override
  public Edge[] getEdges(){
    return this.edges;
  }

  @Override
  public Vertex[] getVertices(){
    return this.vertices;
  }

  @Override
  public Edge[] getNeighborEdges(Vertex v){
    if(v.getId() >= this.incidenceArray.length){
      throw new IllegalArgumentException("Vertex id exceeds incidenceArray size");
    }

    return incidenceArray[v.getId()];
  }
  
  @Override
  public String toString(){
    return "";
  }
}