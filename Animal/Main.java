public class Main {
  public static void main(String[] args){
    // TODO: fix bug
    Animal[] animals = new Animal[10];
    Lion l = new Lion();
    l.run();

    for(int i = 0;i < 5;i++){
      animals[i] = new Goldfish();
    }

    for(int i = 5;i < 10;i++){
      animals[i] = new Lion();
    }

    for(int i = 0;i < 10;i++){
      if(animals[i] instanceof canRun){
        animals[i].run();
      }
    }
  }
}