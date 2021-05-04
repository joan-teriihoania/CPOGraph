package graph;

public abstract class Edge {
      private static int lastId = 0;
      private int id;
      private Vertex[] ends;
      private String color;
      private double value;

      /**
      * Create an edge
      * @see Vertex
      */
      public Edge(){
        this("white", 0);
      }
      /**
      * Create an edge
      * @see Vertex
      * @param color The color of the {@link Edge}
      * @param value The value of the {@link Edge}
      */
      public Edge(String color, double value){
        this.id = lastId;
        this.color = color;
        this.ends = new Vertex[2];
        lastId++;
      };
      /**
      * Get the color of the {@link Edge}
      * @return The color of the {@link Edge}
      */
      public String getColor(){
        return this.color;
      }
      /**
      * Get the two edges of the {@link Edge}
      * @return The two enges of the {@link Edge} in an array
      */
      public Vertex[] getEnds(){
        return ends;
      }
      /**
      * Set the two edges array of the {@link Edge}
      * @return The two enges of the {@link Edge} in an array
      */
      public void setEnds(Vertex[] ends){
        this.ends = ends;
      }

      public String toString(){
        return "color: " + this.getColor() + " value: " + this.value;
      }
}