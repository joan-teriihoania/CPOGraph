public class AquaticPokemon extends Pokemon{
  private int nbFins;

  public AquaticPokemon(){
    this(0);
  }

  public AquaticPokemon(int nbFins){
    super();
    this.nbFins = nbFins;
  }

  public AquaticPokemon setNbFins(int nbFins) {
    this.nbFins = nbFins;
    return this;
  }

  public int getNbFins() {
    return nbFins;
  }

  @Override
  public float getSpeed(){
    return super.getWeight() / 25 * nbFins;
  }

  @Override
  public String toString(){
    return super.toString() + ", I have " + this.nbFins + " fins";
  }
}