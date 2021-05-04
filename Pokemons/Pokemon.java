public abstract class Pokemon {
  private String name;
  private float weight;

  public Pokemon(){
    this("", 0, 0);
  }

  public Pokemon(String name, float weight, float height){
    this.name = name;
    this.weight = weight;
  }

  public abstract float getSpeed();
  public String getName(){return this.name;}
  public float getWeight(){return this.weight;}
  
  public Pokemon setName(String name){
    this.name = name;
    return this;
  }

  public Pokemon setWeight(float weight){
    this.weight = weight;
    return this;
  }

  
  @Override
  public String toString(){
    return "I am the pokemon "+getName()+", my weight is "+getWeight()+"kg, my speed is "+getSpeed()+" km/h";
  }
}