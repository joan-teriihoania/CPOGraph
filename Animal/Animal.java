public abstract class Animal {
  String name;
  boolean alive;

  public Animal(){
    this("");
  }
  
  public Animal(String name){
    this.name = name;
  }

  public boolean isAlive(){
    return alive;
  }

  public void setAlive(boolean alive){
    this.alive = alive;
  }

  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name = name;
  }
}