public class CruisingPokemon extends AquaticPokemon{
  @Override
  public float getSpeed(){
    return super.getSpeed()/2;
  }
}