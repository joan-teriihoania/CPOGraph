public class MainPokemon {
  public static void main(String[] args) {
    SportsPokemon sp = new SportsPokemon();
    sp
      .setBPM(120)
      .setNbLegs(2)
      .setHeight(0.85f)
      .setName("Pikachu")
      .setWeight(18);

    StayAtHomePokemon s = new StayAtHomePokemon();
    s
      .setHoursTV(8)
      .setNbLegs(2)
      .setHeight(0.65f)
      .setName("Salameche")
      .setWeight(12);
    
    SeaPokemon c = new SeaPokemon();
    c
      .setNbFins(2)
      .setName("Rondoudou")
      .setWeight(45);
    
    CruisingPokemon se = new CruisingPokemon();
    se
      .setNbFins(3)
      .setName("Bulbizarre")
      .setWeight(15);
    


    System.out.println(sp);
    System.out.println(s);
    System.out.println(c);
    System.out.println(se);

    Pokemon[] pokemons = new Pokemon[10];
    for(int i = 0;i < 5;i++){
      pokemons[i] = new SeaPokemon()
        .setNbFins(2)
        .setName("Rondoudou")
        .setWeight(45);
    }
    for(int i = 5;i < 10;i++){
      pokemons[i] = new SportsPokemon()
        .setBPM(120)
        .setNbLegs(2)
        .setHeight(0.85f)
        .setName("Pikachu")
        .setWeight(18);
    }

    PokemonCollection equip = new PokemonCollection(pokemons);
    System.out.println(equip.getAverageSpeed());
    System.out.println(equip.getAverageSpeed(SeaPokemon.class));
    System.out.println(equip.getAverageSpeed(SportsPokemon.class));
  }
}