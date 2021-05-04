package graph;

public class Vertex {
      private static int lastId = 0;
      private int id;
      private Object info;
      private String color;
      
      public Vertex(){
        this(null, "white");
      }
      public Vertex(Object info, String color){
        this.id = lastId;
        this.info = info;
        this.color = color;
        lastId++;
      };
      
      public Object getInfo(){
        return this.info;
      }
      public String getColor(){
        return this.color;
      }
      public String toString(){
        return "color: " + this.getColor() + " info: " + this.getInfo();
      }

      public void setColor(){
        this.color = color;
      }
      public void setInfo(Object info){
        this.info = info;
      }
}