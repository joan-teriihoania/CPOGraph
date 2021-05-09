package graphImplementation;

import graph.*;
import java.lang.Math;
import java.awt.Color;

public class IncidenceArrayGraph implements Graph {
  private Vertex[] vertices;
  private Edge[] edges;
  private Edge[][] incidenceArray;

  public IncidenceArrayGraph(int n){
    // int m = (int)Math.ceil(n*(n-1)/2);
    int m = 2*n;
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
      if(this.vertices[i] == null){
        count++;
      }
    }
    return count;
  }

  @Override
  public int nbOfEdges(){
    int count = 0;
    for (int i = 0; i < this.edges.length; i++) {
      if(this.edges[i] == null){
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
  
/*
  @Override
  public void addEdge(Vertex v1, Vertex v2, EdgeKind kind){
    Edge e;
    Vertex[] tmp = new Vertex[2];
    tmp[0] = v1;
    tmp[1] = v2;

    switch(kind){
      case directed:
        e = new DirectedEdge(0, Color.WHITE, tmp, 0, 0);
        addEdge(e, v1, v2);
        break;
      case undirected:
        e = new UndirectedEdge(0, Color.WHITE, tmp, 0);
        addEdge(e, v1, v2);
        break;
    }
  }
*/

  public void addEdge(Vertex v1, Vertex v2, EdgeKind kind) {
    Edge e; 
    Vertex[] tmp = new Vertex [2]; 
    tmp [0] = v1;
    tmp [1] = v2;

    if (kind == EdgeKind.directed) {
      e = new DirectedEdge(0, Color.WHITE, tmp, 0, 0); 
    } else {
      e = new UndirectedEdge(0, Color.WHITE, tmp, 0);
    }
    edges[e.getId()] = e;

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


/*
  public boolean isConnected(Vertex v1, Vertex v2){
    return isConnected(v1, v2, new Vertex[this.vertices.length]);
  }

  private boolean isConnected(Vertex v1, Vertex v2, Vertex[] visited){
    if (v1 == v2){ return true; }
    for (int i = 0; i < visited.length; i++) {
      if(visited[i] == v1){
        return false;
      }
    }

    for (int i = 0; i < this.incidenceArray[v1.getId()].length; i++) {
      if(this.incidenceArray[v1.getId()][i] != null){
        Vertex[] ends = this.incidenceArray[v1.getId()][i].getEnds();
        for (int j = 0; j < visited.length; j++) {
          if(visited[j] == null){
            visited[j] = v1;
            return isConnected(ends[0], v2, visited) || isConnected(ends[0], v2, visited);
          }
        }
      }
    }

    return false;
  }

  @Override
  public boolean isConnected(){
    boolean isC = true;
    Vertex v1 = this.vertices[0];
    int i = 1;
    while(isC && i < this.nbOfVertices()){
      isC = isConnected(v1, this.vertices[i]);
      i++;
    }
    return isC;

  }
  */
  
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
      res = this.isConnected(this.vertices[0], this.vertices[i]);
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
    return incidenceArray[v.getId()];
  }
  
  @Override
  public String toString(){
    return "";
  }
}