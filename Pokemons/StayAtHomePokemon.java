public class StayAtHomePokemon extends EarthlyPokemon{
  private int hoursTV;

  public int getHoursTV(){return this.hoursTV;}
  
  public StayAtHomePokemon setHoursTV(int hoursTV){
    this.hoursTV = hoursTV;
    return this;
  }

  @Override
  public String toString(){
    return super.toString() + ", I watch TV " + this.hoursTV + " hours per day";
  }
}