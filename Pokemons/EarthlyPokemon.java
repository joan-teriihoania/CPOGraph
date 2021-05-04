public class EarthlyPokemon extends Pokemon {
  private int nbLegs;

  public EarthlyPokemon(){
    this(0);
  }

  public EarthlyPokemon(int nbLegs){
    super();
    this.nbLegs = nbLegs;
  }

  public int getNbLegs() {
    return nbLegs;
  }

  public EarthlyPokemon setNbLegs(int nbLegs) {
    this.nbLegs = nbLegs;
    return this;
  }


  private float height;
  public float getHeight(){return this.height;}

  public Pokemon setHeight(float height){
    this.height = height;
    return this;
  }

  @Override
  public float getSpeed(){
    return nbLegs * getHeight() * 3;
  }

  @Override
  public String toString(){
    return super.toString() + ", I have " + this.nbLegs + " legs, my size is "+getHeight()+"m";
  }
}