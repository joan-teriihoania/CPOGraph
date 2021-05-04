public class PokemonCollection {
  Pokemon[] pokemons;

  public PokemonCollection(Pokemon[] pokemons){
    this.pokemons = pokemons;
  }

  public float getAverageSpeed(){
    return getAverageSpeed(Object.class);
  }

  // To get the average speed of a specific class
  // Example: getAverageSpeed(SportsPokemon.class)
  public float getAverageSpeed(Class c){
    float sum = 0;
    float count = 0;

    for(int i = 0;i < pokemons.length;i++){
      if(
        pokemons[i].getClass().toString().equals(c.toString()) ||
        c.toString().equals(Object.class.toString())
      ){
        count++;
        sum += pokemons[i].getSpeed();
      }
    }

    if(count == 0) return 0;
    return sum/count;
  }
}