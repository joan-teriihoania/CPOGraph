public class SportsPokemon extends EarthlyPokemon {
  private int bpm;

  public int getBPM(){return this.bpm;}
  public SportsPokemon setBPM(int bpm){
    this.bpm = bpm;
    return this;
  }

  @Override
  public String toString(){
    return super.toString() + ", my heart rate is " + getBPM() + "bpm";
  }
}